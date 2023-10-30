package racingcar.enums;

public enum RegexPattern {
    CAR_NAME("^[a-zA-Z]+$"),
    CAR_COUNT("^[1-9]\\d*$");

    private final String pattern;

    RegexPattern(final String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
