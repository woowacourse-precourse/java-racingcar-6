package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.mock.FakeMovingStrategy.ALWAYS_MOVING_STRATEGY;
import static racingcar.mock.FakeMovingStrategy.NEVER_MOVING_STRATEGY;

import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    void 자동차는_전진할_수_있다() {
        RacingCar alwaysMovingRacingCar = new RacingCar("name", ALWAYS_MOVING_STRATEGY);
        int initialCarPosition = alwaysMovingRacingCar.getPosition();

        alwaysMovingRacingCar.race();
        int currentCarPosition = alwaysMovingRacingCar.getPosition();
        assertThat(currentCarPosition).isEqualTo(initialCarPosition + 1);
    }

    @Test
    void 자동차는_이동_조건이_만족되지_않으면_이동하지_않을_수도_있다() {
        RacingCar neverMovingRacingCar = new RacingCar("name", NEVER_MOVING_STRATEGY);
        int initialCarPosition = neverMovingRacingCar.getPosition();

        neverMovingRacingCar.race();
        neverMovingRacingCar.race();
        neverMovingRacingCar.race();

        int currentCarPosition = neverMovingRacingCar.getPosition();
        assertThat(currentCarPosition).isEqualTo(initialCarPosition);
    }
}
