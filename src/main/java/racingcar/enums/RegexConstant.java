package racingcar.enums;

public enum RegexConstant {
    DIGIT_REGEX("^[0-9]+$");

    private final String regex;

    RegexConstant(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
