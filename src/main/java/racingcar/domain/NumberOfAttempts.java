package racingcar.domain;

public class NumberOfAttempts {

    private int numberOfAttempts;

    public NumberOfAttempts(int numberOfAttempts) {
        validateNumberOfAttempts(numberOfAttempts);
        this.numberOfAttempts = numberOfAttempts;
    }

    private void validateNumberOfAttempts(int numberOfAttempts) {
        if (!(1 <= numberOfAttempts && numberOfAttempts <= 100)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상 100 이하만 가능합니다.");
        }
    }

    public boolean hasRemainingAttempts() {
        return numberOfAttempts > 0;
    }

    public void decreaseNumberOfAttempts() {
        numberOfAttempts--;
    }
}
