package racingcar.validator;

public class InputValidator {
    private static final String ATTEMPT_COUNT_UNDER_0 = "시도할 횟수는 1번 이상이어야 합니다.";

    public void validateAttemptCount(String attempt) {
        int attemptCount = Integer.parseInt(attempt);
        if (attemptCount <= 0) {
            throw new IllegalArgumentException(ATTEMPT_COUNT_UNDER_0);
        }
    }
}
