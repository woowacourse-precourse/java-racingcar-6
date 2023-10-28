package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 모든_자동차_움직이지_않는_기능_테스트(int randomNumber) {
        // given
        final Cars cars = new Cars(List.of(new Car("pobi"), new Car("woni"), new Car("jun")));

        // when
        List<String> locationInformation = cars.moveCars(randomNumber);

        // then
        Assertions.assertThat(locationInformation).hasSize(3)
                .contains("pobi : ", "woni : ", "jun : ");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 모든_자동차_움직이는_기능_테스트(int randomNumber) {
        // given
        final Cars cars = new Cars(List.of(new Car("pobi"), new Car("woni"), new Car("jun")));

        // when
        List<String> locationInformation = cars.moveCars(randomNumber);

        // then
        Assertions.assertThat(locationInformation).hasSize(3)
                .contains("pobi : -", "woni : -", "jun : -");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 우승자_테스트(int randomNumber) {
        // given
        final Cars cars = new Cars(List.of(new Car("pobi"), new Car("woni")));

        // when
        cars.moveCars(randomNumber);
        String winnerCars = cars.findWinnerCars();

        // then
        Assertions.assertThat(winnerCars).isEqualTo("pobi, woni");
    }

    @Test
    public void 이름_중복_테스트() {
        // given
        final List<Car> cars = List.of(new Car("pobi"), new Car("woni"), new Car("pobi"));

        // then
        Assertions.assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }
}