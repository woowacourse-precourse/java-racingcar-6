package racingcar.racer;

import racingcar.util.Random;
import racingcar.validator.RacingCarValidator;

public class RacingCar extends Car implements Raceable {

    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;
    private static final int MOVING_FORWARD = 4;

    private int position;

    protected RacingCar(String name) {
        super(name);

        RacingCarValidator.validateNameLength(name);
        RacingCarValidator.validateNameFormat(name);
    }

    public static RacingCar nameOf(String name) {
        return new RacingCar(name);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public void move() {
        moveForwardOrStop();
    }

    private void moveForwardOrStop() {
        int number = Random.getRandomNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
        if (number >= MOVING_FORWARD) {
            ++position;
        }
    }

    @Override
    public String toString() {
        return "RacingCar " + name + "{" +
                "position=" + position +
                '}';
    }
}
