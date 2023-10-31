package racingcar.racer;

import racingcar.util.Random;
import racingcar.validator.RacingCarValidator;

public class RacingCar extends Racer {

    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;
    private static final int MIN_MOVING_FORWARD_NUMBER = 4;

    protected RacingCar(String name) {
        super(name);

        RacingCarValidator.validateNameLength(name);
        RacingCarValidator.validateNameFormat(name);
    }

    public static RacingCar from(String name) {
        return new RacingCar(name);
    }

    @Override
    public void move() {
        moveForwardOrStop();
    }

    private void moveForwardOrStop() {
        int number = Random.getRandomNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
        if (number >= MIN_MOVING_FORWARD_NUMBER) {
            ++position;
        }
    }
}
