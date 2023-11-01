package racingcar.domain.racer;

public class RacingCar extends Racer {

    private static final int MIN_MOVING_FORWARD_NUMBER = 4;

    protected RacingCar(String name) {
        super(name);
    }

    public static RacingCar from(String name) {
        return new RacingCar(name);
    }

    @Override
    public void move(int number) {
        moveForwardOrStop(number);
    }

    private void moveForwardOrStop(int number) {
        if (number >= MIN_MOVING_FORWARD_NUMBER) {
            ++position;
        }
    }
}
