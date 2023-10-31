package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("자동차 이름들을 받아서 자동차들을 생성한다.")
    void of() {
        Cars cars = Cars.of("pobi,crong,honux");

        assertThat(cars).isEqualTo(Cars.of("pobi,crong,honux"));
    }

    @Test
    @DisplayName("자동차들을 받아서 자동차들을 이동할 수 있다. - 모두 한칸식 이동")
    void move() {
        Cars cars = Cars.of("pobi,crong,honux");
        Cars movedCars = cars.moves(() -> 4);
        assertThat(movedCars).isEqualTo(Cars.ofWithCount("pobi,crong,honux", 1));
    }

    @Test
    @DisplayName("실행 결과에서 우승자를 구한다.")
    void winners() {
        Cars cars = Cars.of("pobi,crong,honux");
        Cars movedCars = cars.moves(() -> 4);
        assertThat(movedCars.winners()).isEqualTo("pobi,crong,honux");
    }

    @Test
    @DisplayName("자동차들의 이름과 위치를 반환한다.")
    void toStringTest() {
        Cars cars = Cars.of("pobi,crong,honux");
        Cars movedCars = cars.moves(() -> 4);
        assertThat(movedCars.toString()).isEqualTo("pobi : -\ncrong : -\nhonux : -");
    }

}