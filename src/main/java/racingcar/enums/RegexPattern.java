package racingcar.enums;

import java.util.regex.Pattern;

public enum RegexPattern {
    NOT_INCLUDE_COMMA(Pattern.compile("^[^,]*$")),
    NOT_CAR_NAME_COND(Pattern.compile("^(?!^[\\sa-zA-Z0-9가-힣]*$).+")),
    BLANK_IN_START(Pattern.compile("^\\s.*")),
    BLANK_IN_END(Pattern.compile(".*\\s$")),
    NOT_ONLY_NUMBER(Pattern.compile(".*[\\D].*"));

    private final Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public boolean matches(String input) {
        return pattern.matcher(input).matches();
    }
}
