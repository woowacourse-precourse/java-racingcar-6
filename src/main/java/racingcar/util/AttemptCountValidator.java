package racingcar.util;

public class AttemptCountValidator {

    private final static String INVALID_ATTEMPT_COUNT_MESSAGE = "시도 횟수는 숫자로만 입력해야 합니다";

    public void validateAttemptCount(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT_MESSAGE);
        }
    }

    private boolean isNumeric(String input) {
        return input.matches("\\d+");
    }

}
