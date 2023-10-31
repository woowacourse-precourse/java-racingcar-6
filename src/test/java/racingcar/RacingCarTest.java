package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.validator.RacingCarValidator;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private static final RacingCarGameFactory racingCarGameFactory = new MockRacingCarGameFactory();

    private static final String RACING_CAR_NAME = "semin";
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final int DISTANCE_WHEN_STOP = 0;
    private static final String MOVING_BAR_WHEN_STOP = "";
    private static final int DISTANCE_WHEN_MOVING_FORWARD = 1;
    private static final String MOVING_BAR_WHEN_MOVING_FORWARD = "-";

    private RacingCarValidator racingCarValidator;
    private MockRandomNumberGenerator mockRandomNumberGenerator;

    @BeforeEach
    void init() {
        racingCarValidator = racingCarGameFactory.racingCarValidator();
        mockRandomNumberGenerator = (MockRandomNumberGenerator) racingCarGameFactory.randomNumberGenerator();
    }

    @Test
    void 전진() {
        mockRandomNumberGenerator.init(MOVING_FORWARD);
        RacingCar racingCar = new RacingCar(racingCarValidator, mockRandomNumberGenerator, RACING_CAR_NAME);
        racingCar.move();

        assertThat(racingCar.getDistance()).isEqualTo(DISTANCE_WHEN_MOVING_FORWARD);
        assertThat(racingCar.getMovingBar()).isEqualTo(MOVING_BAR_WHEN_MOVING_FORWARD);
    }

    @Test
    void 멈춤() {
        mockRandomNumberGenerator.init(STOP);
        RacingCar racingCar = new RacingCar(racingCarValidator, mockRandomNumberGenerator, RACING_CAR_NAME);
        racingCar.move();

        assertThat(racingCar.getDistance()).isEqualTo(DISTANCE_WHEN_STOP);
        assertThat(racingCar.getMovingBar()).isEqualTo(MOVING_BAR_WHEN_STOP);
    }
}
