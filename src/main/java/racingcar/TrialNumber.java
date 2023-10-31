package racingcar;

public class TrialNumber {
    private static final int MINIMUM_NUMBER = 1;
    private static final String INVALID_NUMBER = "시도 횟수는 최소 1회 이상이어야 합니다.";
    private final int number;

    public TrialNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < MINIMUM_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
    }
}