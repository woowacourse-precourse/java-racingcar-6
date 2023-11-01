package racingcar.constant;

public enum SeparatorConstant {
    NAME_SEPARATOR(","),
    NAME_DASH_SEPARATOR(" : "),
    WINNER_SEPARATOR(", ");

    private final String value;

    SeparatorConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
