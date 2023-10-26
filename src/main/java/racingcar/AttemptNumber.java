package racingcar;

public record AttemptNumber(int number) {

    public AttemptNumber {
        throwIfInvalidAttemptNumber(number);
    }

    private void throwIfInvalidAttemptNumber(int number) {

    }
}
