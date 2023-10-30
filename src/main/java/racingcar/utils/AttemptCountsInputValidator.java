package racingcar.utils;

import java.util.regex.Pattern;

public class AttemptCountsInputValidator {

    private static final Pattern NUMERIC_REGEX = Pattern.compile("^(0|[-]?[1-9]\\d*)$");

    public static void validate(String target) {
        validateNumeric(target);
        validateIntegerRange(target);
        validateRange(target);
    }

    private static void validateNumeric(String target) {
        if (!NUMERIC_REGEX.matcher(target).matches()) {
            throw new IllegalArgumentException(AttemptCountsInputExceptionMessage.NOT_NUMERIC.getError());
        }
    }

    private static void validateIntegerRange(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(AttemptCountsInputExceptionMessage.OUT_OF_INTEGER_RANGE.getError());
        }
    }

    private static void validateRange(String target) {
        int attemptCounts = Integer.parseInt(target);
        if (attemptCounts < 1) {
            throw new IllegalArgumentException(AttemptCountsInputExceptionMessage.OUT_OF_RANGE.getError());
        }
    }

    enum AttemptCountsInputExceptionMessage {
        NOT_NUMERIC("숫자만 입력해야 합니다."),
        OUT_OF_INTEGER_RANGE("int 범위를 벗어났습니다."),
        OUT_OF_RANGE("1회 ~ 2147483647회 만 입력 가능합니다.");

        private final String error;

        AttemptCountsInputExceptionMessage(String error) {
            this.error = error;
        }

        String getError() {
            return error;
        }
    }
}
