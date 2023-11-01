package racingcar.enums;

public enum StringPattern {
    TRIAL_COUNT("^[0-9]*$");

    private final String pattern;

    StringPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
