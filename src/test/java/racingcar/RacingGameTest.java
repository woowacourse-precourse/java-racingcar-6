package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class RacingGameTest {

    @Test
    void 숫자_4이상_나오면_자동차_전진() {
        // given
        Car car = Car.createCar("pobi");

        // when
        car.moveOrStop(4);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 숫자_4미만_나오면_자동차_이동X() {
        // given
        Car car = Car.createCar("pobi");

        // when
        car.moveOrStop(1);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
