package racingcar.util;

public class AttemptCount {
    private int totalAttemptCount;
    public AttemptCount(String totalAttemptCount) {
        this.totalAttemptCount = checkTranslateInteger(totalAttemptCount);
        checkPositiveNumber(this.totalAttemptCount);
    }

    private int checkTranslateInteger(String attempt) {
        try {
            return Integer.parseInt(attempt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("err: 시도 횟수는 숫자여야 합니다.");
        }
    }
    private void checkPositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("err: 양수를 입력해주세요.");
        }
    }
}
