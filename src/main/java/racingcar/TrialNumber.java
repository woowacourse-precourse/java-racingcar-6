package racingcar;

public class TrialNumber {
    private static final int MINIMUM_NUMBER = 1;
    private static final String INVALID_NUMBER = "시도 횟수는 최소 1회 이상이어야 합니다.";
    private static final int ZERO = 0;
    private int number;

    public TrialNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public void subtractOne() {
        number --;
    }

    public boolean isZero() {
        return number == ZERO;
    }

    private void validateNumber(int number) {
        if (number < MINIMUM_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
    }
}