package racingcar.domain;

public class MoveDecider {
    private static final int MOVE_CRITERIA_VALUE = 4;

    private MoveDecider() {
    }

    public static MoveStatus decideToMove(int input) {
        if (input >= MOVE_CRITERIA_VALUE) {
            return MoveStatus.MOVE;
        }
        return MoveStatus.STOP;
    }
}
