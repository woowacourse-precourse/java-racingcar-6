package racingcar.data.attempt;

public class AttemptNumber {
    private final int number;
    private static final String NOT_POSITIVE_INTEGER_EXCEPTION = "attemptNumber should be a positive integer.";

    public AttemptNumber(int number) {
        this.number = number;
    }

    public static void validateAttemptNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_INTEGER_EXCEPTION);
        }
    }

    public int toInt() {
        return number;
    }
}
