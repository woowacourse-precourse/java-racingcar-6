package racingcar.enums;

public enum Separator {
    JOIN_SEPARATOR(", "),
    COMMA(","),
    BLANK(" ");

    private final String separator;

    Separator(String separator) {
        this.separator = separator;
    }

    public String toString() {
        return separator;
    }
}
