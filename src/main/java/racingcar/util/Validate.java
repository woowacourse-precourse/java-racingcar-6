package racingcar.util;

public class Validate {
    public static String isValidCarName(String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException();
        }
        return carName;
    }

    public static String isValidAttemptNumber(String attemptNumber) {
        if (attemptNumber.matches("^\\d{1,3}$")) {
            throw new IllegalArgumentException();
        }
        return attemptNumber;
    }
}
