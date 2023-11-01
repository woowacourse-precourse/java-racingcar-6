package racingcar;

public class MovingRule {
    private static final int BOUNDARY_MOVE_NUMBER = 4;

    public boolean isMovable(int number) {
        return number >= BOUNDARY_MOVE_NUMBER;
    }
}
