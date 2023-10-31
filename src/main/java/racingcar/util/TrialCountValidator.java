package racingcar.util;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TrialCountValidator {

    private static final String POSITIVE_NUMBER_REGEX = "^[1-9]+[0-9]*$";
    private static final String POSITIVE_NUMBER_ERROR_MESSAGE = "양수가 아닙니다.";
    private static final String INTEGER_RANGE_ERROR_MESSAGE = "int 범위 숫자가 아닙니다.";

    private TrialCountValidator() {
    }

    public static void validate(final String trialCount) {
        validatePositiveNumber(trialCount);
        validateIntegerRange(trialCount);
    }

    private static void validatePositiveNumber(final String trialCount) {
        Pattern pattern = Pattern.compile(POSITIVE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(trialCount);
        if (!matcher.find()) {
            throwException(POSITIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validateIntegerRange(final String trialCount) {
        if (isBiggerThanIntegerMax(new BigInteger(trialCount))) {
            throwException(INTEGER_RANGE_ERROR_MESSAGE);
        }
    }

    private static boolean isBiggerThanIntegerMax(final BigInteger bigInteger) {
        return bigInteger.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0;
    }

    private static void throwException(final String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }

}
