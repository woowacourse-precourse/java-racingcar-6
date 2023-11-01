package racingcar.model.enums;

public enum MovingStatus {

    STOP(0),
    FOR_WORD(4);

    private final int moveRange;

    MovingStatus(int moveRange) {
        this.moveRange = moveRange;
    }

    public static boolean canMove(int pickNumber) {
        return pickNumber >= FOR_WORD.moveRange;
    }
}
