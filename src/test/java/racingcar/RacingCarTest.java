package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.validator.RacingCarValidator;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private static final String RACING_CAR_NAME = "semin";
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final int DISTANCE_WHEN_STOP = 0;
    private static final String MOVING_BAR_WHEN_STOP = "";
    private static final int DISTANCE_WHEN_MOVING_FORWARD = 1;
    private static final String MOVING_BAR_WHEN_MOVING_FORWARD = "-";

    private final RacingCarValidator racingCarValidator = new RacingCarValidator();

    @Test
    void 전진() {
        MockRandomNumberGenerator randomNumberGenerator = new MockRandomNumberGenerator(MOVING_FORWARD);
        RacingCar racingCar = new RacingCar(racingCarValidator, randomNumberGenerator, RACING_CAR_NAME);
        racingCar.move();

        assertThat(racingCar.getDistance()).isEqualTo(DISTANCE_WHEN_MOVING_FORWARD);
        assertThat(racingCar.getMovingBar()).isEqualTo(MOVING_BAR_WHEN_MOVING_FORWARD);
    }

    @Test
    void 멈춤() {
        MockRandomNumberGenerator randomNumberGenerator = new MockRandomNumberGenerator(STOP);
        RacingCar racingCar = new RacingCar(racingCarValidator, randomNumberGenerator, RACING_CAR_NAME);
        racingCar.move();

        assertThat(racingCar.getDistance()).isEqualTo(DISTANCE_WHEN_STOP);
        assertThat(racingCar.getMovingBar()).isEqualTo(MOVING_BAR_WHEN_STOP);
    }
}
