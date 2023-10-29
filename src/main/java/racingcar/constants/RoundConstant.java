package racingcar.constants;

public enum RoundConstant {
    NUMBER_PATTERN("^[\\d]*$"),
    ZERO("0");

    private String value;

    RoundConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
