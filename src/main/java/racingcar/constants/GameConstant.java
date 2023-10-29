package racingcar.constants;

public enum GameConstant {

    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9),
    SEPARATOR(44);

    private int value;
    GameConstant(int constant) {
        this.value = constant;
    }

    public int getValue() {
        return value;
    }

    public String getStringValue() {
        return String.valueOf((char) value);
    }
}
