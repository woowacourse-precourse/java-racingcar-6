package racingcar.constants;

import java.util.regex.Pattern;

public enum InputPattern {
    CAR_NAMES_PATTERN(Pattern.compile("^\\w+[?:,\\w+]*$"));

    private final Pattern pattern;

    InputPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public static boolean isNotMatchCarNamesPattern(String carNames) {
        Pattern pattern = CAR_NAMES_PATTERN.pattern;
        return !pattern.matcher(carNames).matches();
    }

}
