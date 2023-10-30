package racingcar.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrialCountValidator {

    private static final String POSITIVE_NUMBER_REGEX = "^[1-9]+[0-9]*$";
    private static final String POSITIVE_NUMBER_ERROR_MESSAGE = "양수가 아닙니다.";
    private static final String RANGE_ERROR_MESSAGE = "int 범위 숫자가 아닙니다.";

    private TrialCountValidator() {
    }

    public static void validate(final String trialCount) {
        validatePositiveNumber(trialCount);
        validateRange(trialCount);
    }

    private static void validatePositiveNumber(final String trialCount) {
        Pattern pattern = Pattern.compile(POSITIVE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(trialCount);
        if (!matcher.find()) {
            throw new IllegalArgumentException(POSITIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validateRange(final String trialCount) {
        long parseLong = Long.parseLong(trialCount);
        if (parseLong > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

}
