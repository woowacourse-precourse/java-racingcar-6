package racingcar.constant;

public enum SeparatorConstant {
    NAME_SEPARATOR(","),
    NAME_DASH_SEPARATOR(" : "),
    WINNER_SEPARATOR(", "),
    EMPTY_STRING(""),
    NEW_LINE("\n");

    private final String value;

    SeparatorConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
