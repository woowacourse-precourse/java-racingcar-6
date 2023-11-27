package racingcar.view.input.constant;

public enum InputValueConstant {
    NUMERIC_INPUT_UNDER_LIMIT(0);
    private final int value;

    InputValueConstant(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}