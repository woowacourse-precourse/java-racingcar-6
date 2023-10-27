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

    @Test
    public void 우승자_한_명인_경우_테스트() {
        // given
        final Cars cars = new Cars(List.of(new Car("pobi", "---"),
                new Car("jun", "--"),
                new Car("woni", "--")));

        // when
        final List<Car> winnerCars = cars.getWinnerCars();

        final List<String> winnersName = cars.getNamesOfCars(winnerCars);

        // then
        Assertions.assertThat(winnersName).hasSize(1)
                .contains("pobi");
    }

    @Test
    public void 우승자_여러_명인_경우_테스트() {
        // given
        final Cars cars = new Cars(List.of(new Car("pobi", "---"),
                new Car("jun", "---"),
                new Car("woni", "--")));

        // when
        final List<Car> winnerCars = cars.getWinnerCars();

        final List<String> winnersName = cars.getNamesOfCars(winnerCars);

        // then
        Assertions.assertThat(winnersName).hasSize(2)
                .contains("pobi", "jun");
    }
}