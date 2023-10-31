package racingcar.constants;

public enum UtilConstant {

    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9),
    SEPARATOR(44);

    private int value;

    UtilConstant(int constant) {
        this.value = constant;
    }

    public int getValue() {
        return value;
    }

    public String getStringValue() {
        return String.valueOf((char) value);
    }
}
