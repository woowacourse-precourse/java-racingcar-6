package racingcar.constant.regex;

public enum RoundRegex {
    NUMBER("\\d+");

    private final String regex;

    RoundRegex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
