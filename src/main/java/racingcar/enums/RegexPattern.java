package racingcar.enums;

import java.util.regex.Pattern;

public enum RegexPattern {
    INCLUDE_COMMA(Pattern.compile(".*,.*")),
    CAR_NAME_COND(Pattern.compile("^[\\sa-zA-Z0-9가-힣]*$")),
    BLANK_IN_START(Pattern.compile("^\\s.*")),
    BLANK_IN_END(Pattern.compile(".*\\s$")),
    ONLY_NUMBER(Pattern.compile("^[0-9]*$"));

    private final Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public boolean matches(String input) {
        return pattern.matcher(input).matches();
    }
}
