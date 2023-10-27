package racingcar.system;

public enum SystemConstant {
    MOVE_STANDARD(4),
    MAX_NAME_LENGTH(5);

    private final int value;

    SystemConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
