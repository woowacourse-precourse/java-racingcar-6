package racingcar.util;

public enum StringConstants {
    COMMA(","),
    COLON_WITH_SPACE(" : "),
    DASH("-");

    private final String value;

    StringConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}