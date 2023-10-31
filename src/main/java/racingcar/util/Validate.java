package racingcar.util;

public class Validate {
    public static String isValidCarName(String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException();
        }
        return carName;
    }

    public static String isValidAttemptNumber(String attemptNumber) {
        if (!attemptNumber.matches("^[1-9]\\d{0,2}$")) {
            throw new IllegalArgumentException();
        }
        return attemptNumber;
    }
}
