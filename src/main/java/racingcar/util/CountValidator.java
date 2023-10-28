package racingcar.util;

import java.util.List;

public class CountValidator {
    public static void validateAttemptCountOverZero(int numberOfAttempt) {
        if (numberOfAttempt <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
