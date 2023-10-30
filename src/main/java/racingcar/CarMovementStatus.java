package racingcar;

public enum CarMovementStatus {
    MOVE_FORWARD, STOP;
    public static CarMovementStatus getMovementStatusByCheckNumber(final Integer targetNumber) {
        if(targetNumber > 3) return MOVE_FORWARD;
        return STOP;
    }
}
