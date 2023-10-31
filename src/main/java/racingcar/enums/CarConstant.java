package racingcar.enums;

public enum CarConstant {
    MIN_NAME_LENGTH(1),
    MAX_NAME_LENGTH(5),
    CAN_FORWARD_NUMBER(4);

    private final int number;

    CarConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
