package racingcar.domain;

public class NumberOfAttempts {

    private static final int MIN_NUMBER_OF_ATTEMPTS = 1;
    private static final int MAX_NUMBER_OF_ATTEMPTS = 100;
    private static final int ZERO = 0;

    private int numberOfAttempts;

    public NumberOfAttempts(int numberOfAttempts) {
        validateNumberOfAttempts(numberOfAttempts);
        this.numberOfAttempts = numberOfAttempts;
    }

    private void validateNumberOfAttempts(int numberOfAttempts) {
        if (isOutOfRange(numberOfAttempts)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 %d 이상 %d 이하만 가능합니다."
                    .formatted(MIN_NUMBER_OF_ATTEMPTS, MAX_NUMBER_OF_ATTEMPTS));
        }
    }

    private boolean isOutOfRange(int numberOfAttempts) {
        return !(MIN_NUMBER_OF_ATTEMPTS <= numberOfAttempts && numberOfAttempts <= MAX_NUMBER_OF_ATTEMPTS);
    }

    public boolean hasRemainingAttempts() {
        return numberOfAttempts > ZERO;
    }

    public void decreaseNumberOfAttempts() {
        numberOfAttempts--;
    }
}
