package racingcar.domain;

public enum MoveCondition {
    MOVE(1), STOP(0);

    private static final int CRITICAL_POINT = 4;

    public final int distance;

    MoveCondition(int distance) {
        this.distance = distance;
    }

    public boolean isMove() {
        return this.equals(MOVE);
    }

    public static MoveCondition convertToCarStatus(Integer randomNumber) {
        if (randomNumber >= CRITICAL_POINT) {
            return MOVE;
        }
        return STOP;
    }
}
