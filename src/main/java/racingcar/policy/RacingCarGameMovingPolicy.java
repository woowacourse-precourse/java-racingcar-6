package racingcar.policy;

public class RacingCarGameMovingPolicy implements MovingPolicy {

    private static final int MOVABLE_MIN_NUMBER = 4;

    @Override
    public boolean canMove(int number) {
        return number >= MOVABLE_MIN_NUMBER;
    }

}
