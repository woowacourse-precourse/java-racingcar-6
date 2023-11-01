package racingcar.util;

import java.util.regex.Pattern;

public class PatternChecker {
    public static boolean checkPattern(Pattern pattern, String input) {
        return !pattern.matcher(input).matches();
    }
}
