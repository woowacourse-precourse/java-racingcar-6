package racingcar.util;

public class AttemptCountValidator {

    private final static String INVALID_ATTEMPT_COUNT_MESSAGE = "시도 횟수는 숫자로만 입력해야 합니다";

    public static void validateAttemptCount(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT_MESSAGE);
        }
    }

}
