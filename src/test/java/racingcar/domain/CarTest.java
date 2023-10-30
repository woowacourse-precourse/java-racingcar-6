package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("4 이상이면 전진")
    void goOrStopTestGo() {
        // given
        Car car = new Car("pobi");
        int randomNumber = 4;

        // when
        car.goOrStop(randomNumber);

        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("4 미만이면 정지")
    void goOrStopTestStop() {
        // given
        Car car = new Car("pobi");
        int randomNumber = 3;

        // when
        car.goOrStop(randomNumber);

        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }
}
