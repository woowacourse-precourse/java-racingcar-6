package racingcar.utils;

import java.util.regex.Pattern;

public class AttemptCountsInputValidator {

    private static final Pattern NUMERIC_REGEX = Pattern.compile("^(0|[-]?[1-9]\\d*)$");
    private static final int MIN_ATTEMPT_COUNT = 1;
    private static final int MAX_ATTEMPT_COUNT = 10;


    public static void validate(String target) {
        validateNumeric(target);
        validateInteger(target);
        validateRange(target);
    }

    private static void validateNumeric(String target) {
        if (!NUMERIC_REGEX.matcher(target).matches()) {
            throw new IllegalArgumentException(AttemptCountsInputExceptionMessage.NOT_NUMERIC.getError());
        }
    }

    private static void validateInteger(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(AttemptCountsInputExceptionMessage.NOT_INTEGER.getError());
        }
    }

    private static void validateRange(String target) {
        int attemptCounts = Integer.parseInt(target);
        if (attemptCounts < MIN_ATTEMPT_COUNT || attemptCounts > MAX_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(AttemptCountsInputExceptionMessage.OUT_OF_RANGE.getError());
        }
    }

    enum AttemptCountsInputExceptionMessage {
        NOT_NUMERIC("숫자만 입력해야 합니다."),
        NOT_INTEGER("정수 범위 숫자만 입력해야 합니다."),
        OUT_OF_RANGE(String.format("%d ~ %d 사이의 수만 입력 가능합니다.", MIN_ATTEMPT_COUNT, MAX_ATTEMPT_COUNT));

        private final String error;

        AttemptCountsInputExceptionMessage(String error) {
            this.error = error;
        }

        String getError() {
            return error;
        }
    }
}
