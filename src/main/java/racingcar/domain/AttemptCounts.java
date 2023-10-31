package racingcar.domain;

public class AttemptCounts {
    private static final int MIN_ATTEMPT_NUMBER = 1;
    private static final int MAX_ATTEMPT_NUMBER = 200_000_000;
    private static final String ATTEMPT_NOT_POSITIVE_NUMBER_EXCEPTION = "시도 횟수는 1 이상 2억 이하의 숫자만 입력 가능합니다.";
    private static final String ATTEMPT_NOT_NUMBER_EXCEPTION = "입력값이 숫자가 아닙니다.";
    private int attemptCounts;

    private AttemptCounts(int attemptCounts) {
        this.attemptCounts = attemptCounts;
    }

    public static AttemptCounts from(String inputAttemptCounts) {
        int convertedAttemptCounts = convertAttemptCounts(inputAttemptCounts);
        validateAttemptCounts(convertedAttemptCounts);
        return new AttemptCounts(convertedAttemptCounts);
    }

    private static void validateAttemptCounts(int attemptCounts) {
        if (attemptCounts < MIN_ATTEMPT_NUMBER || MAX_ATTEMPT_NUMBER < attemptCounts) {
            throw new IllegalArgumentException(ATTEMPT_NOT_POSITIVE_NUMBER_EXCEPTION);
        }
    }

    private static int convertAttemptCounts(String attempt) {
        int attemptNumber;
        try {
            attemptNumber = Integer.parseInt(attempt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ATTEMPT_NOT_NUMBER_EXCEPTION);
        }
        return attemptNumber;
    }

    public boolean isRemainAttemptCounts() {
        return MIN_ATTEMPT_NUMBER <= this.attemptCounts;
    }

    public void minusCounts() {
        this.attemptCounts--;
    }
}
