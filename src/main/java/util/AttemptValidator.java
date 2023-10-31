package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AttemptValidator {
    private static final Pattern ATTEMPT_NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    private static final String INVALID_VALUE_MESSAGE = "0이상의 숫자 값이 아닙니다.";

    public static void checkValidAttemptNumber(String number) {
        Matcher numberMatcher = ATTEMPT_NUMBER_PATTERN.matcher(number);

        if (!numberMatcher.matches()) {
            throw new IllegalArgumentException(INVALID_VALUE_MESSAGE);
        }
    }
}
