package racingcar.constant.regex;

public enum NameRegex {
    ALPHABETIC("^[a-zA-Z]+$");

    private final String regex;

    NameRegex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
