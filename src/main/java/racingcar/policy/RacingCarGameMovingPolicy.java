package racingcar.policy;

public class RacingCarGameMovingPolicy implements MovingPolicy {

    public static final int MOVABLE_MIN_NUM = 4;

    @Override
    public boolean canMove(int number) {
        return number >= MOVABLE_MIN_NUM;
    }

}