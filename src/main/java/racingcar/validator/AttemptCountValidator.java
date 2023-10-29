package racingcar.validator;

public class AttemptCountValidator {

    private static final String ATTEMPT_COUNT_ERROR_MESSAGE = "숫자를 입력해주세요";

    public static int validateAttemptCount(String prompt) {
        try {
            return Integer.parseInt(prompt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ATTEMPT_COUNT_ERROR_MESSAGE);
        }
    }
}
