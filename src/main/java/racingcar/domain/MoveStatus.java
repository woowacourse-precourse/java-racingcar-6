package racingcar.domain;

public enum MoveStatus {
    STOP(0),
    GO(1);

    private final int value;

    MoveStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
