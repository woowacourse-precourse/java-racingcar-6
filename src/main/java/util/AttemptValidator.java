package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AttemptValidator {
    private static final Pattern ATTEMPT_NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    public static void checkValidAttemptNumber(String number) {
        Matcher numberMatcher = ATTEMPT_NUMBER_PATTERN.matcher(number);

        if (!numberMatcher.matches()) {
            new IllegalArgumentException();
        }
    }
}
