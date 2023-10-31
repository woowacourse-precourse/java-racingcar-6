package racingcar.util;

public class CountValidator {
    public static void validateAttemptCountOverZero(int numberOfAttempt) {
        if (numberOfAttempt <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
