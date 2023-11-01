package racingcar.controller;

public class AttemptNumberValidator {
    private static final String ATTEMPT_NUMBER_ERROR_MESSAGE = "시도 횟수는 1 이상이어야 합니다.";
    private static final int MIN_ATTEMPT_NUMBER = 1;

    public static void validate(String attemptCount) {
        if (!attemptCount.matches("[0-9]+")) {
            throw new IllegalArgumentException(ATTEMPT_NUMBER_ERROR_MESSAGE);
        }

        if ((Integer.parseInt(attemptCount)) < MIN_ATTEMPT_NUMBER) {
            throw new IllegalArgumentException(ATTEMPT_NUMBER_ERROR_MESSAGE);
        }
    }
}
