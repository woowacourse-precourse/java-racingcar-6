package racingcar.constants;

public enum CarConstant {

    INITIAL_POSITION(0),
    MAX_NAME_LENGTH(5),
    MOVE_NUMBER(4);

    private int value;

    CarConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
