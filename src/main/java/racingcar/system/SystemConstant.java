package racingcar.system;

public enum SystemConstant {
    INITIAL_PROGRESS_NUMBER(0),
    MOVE_STANDARD(4),
    MAX_NAME_LENGTH(5),
    POSITIVE_NUMBER(1),
    MIN_RANDOM_CONSTANT(0),
    MAX_RANDOM_CONSTANT(9);

    private final int value;

    SystemConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
