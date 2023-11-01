package racingcar.constant;

public enum InputConstant {
    DELIMITER(","),
    NUMERIC_PATTERN("^[0-9]*$");

    private String value;

    private InputConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
