package racingcar.utils;

public class MoveDecider {
    private static final int MOVE_CRITERIA_VALUE = 4;

    public static MoveStatus decideToMove(int input) {
        if (input >= MOVE_CRITERIA_VALUE) {
            return MoveStatus.MOVE;
        }
        return MoveStatus.STOP;
    }
}
