package racingcar.constant;

public enum MoveStatus {
    MOVE,
    STOP;

    public boolean isMove() {
        return this == MOVE;
    }
}
