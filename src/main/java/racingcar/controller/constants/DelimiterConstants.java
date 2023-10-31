package racingcar.controller.constants;

public enum DelimiterConstants {
    DELIMITER(","),
    DELIMITER_WITH_BLANK(", ");

    private final String delimiter;

    DelimiterConstants(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getValue() {
        return delimiter;
    }
}
