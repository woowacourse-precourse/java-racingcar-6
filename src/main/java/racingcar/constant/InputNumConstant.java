package racingcar.constant;

public enum InputNumConstant {

    MIN_NAME_LENGTH(1),
    MAX_NAME_LENGTH(5);

    private final int value;

    InputNumConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
