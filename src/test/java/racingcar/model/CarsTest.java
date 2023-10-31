package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차들 객체에 대해")
class CarsTest {

    @Test
    @DisplayName("자동차들의 수가 2보다 작은면 에러가 발생한다.")
    void validate_cars_count() {
        assertThatThrownBy(() -> new Cars("pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차들의 수가 정상적이다.")
    void correct_cars_count() {
        assertThatCode(() -> new Cars("pibi,woni,jun"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("이동한 만큼의 현재 위치를 알 수 있다.")
    void status_car_position() {
        //given
        Cars cars = new Cars("pobi,woni,jun");
        IntStream.range(0, 3)
                .forEach(i -> cars.getRacingCars()
                        .forEach(Car::movePosition));

        //when
        String statusCarsPosition = cars.statusCarsPosition();

        //then
        assertThat(statusCarsPosition).isEqualTo(
                """
                        pobi : ---
                        woni : ---
                        jun : ---
                        """);
    }

    @Test
    @DisplayName("pobi가 레이싱카 최종 우승을 한다.")
    void pobi_final_winners() {
        //given
        Cars cars = new Cars("pobi,woni,jun");
        Car car = cars.getRacingCars().get(0);
        IntStream.range(0, 3)
                .forEach(i -> car.movePosition());

        //when
        String finalWinners = cars.getFinalWinners();

        //then
        assertThat(finalWinners).isEqualTo("pobi");
    }
}
