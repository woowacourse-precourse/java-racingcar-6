package racingcar.validator;

public class AttemptCountValidator {

    private static final String INVALID_INPUT_ERROR_MESSAGE = "숫자를 입력해주세요";
    private static final String MIN_ATTEMPT_COUNT_ERROR_MESSAGE = "1이상을 입력해주세요";

    public static int validateAttemptCount(String prompt) {
        try {
            int attemptCount = Integer.parseInt(prompt);
            checkRange(attemptCount);
            return attemptCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
        }
    }

    private static void checkRange(int attemptCount) {
        if (attemptCount < 1) {
            throw new IllegalArgumentException(MIN_ATTEMPT_COUNT_ERROR_MESSAGE);
        }
    }
}
