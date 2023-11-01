package racingcar.validator;

import racingcar.exception.InvalidNumberOfAttemptsException;
import racingcar.exception.InvalidRacingCarsException;

public class InputValidator {

    public static void validateNumberOfAttempts(String message) {
        try {
            Integer numberOfAttempts = Integer.parseInt(message); // 또는 Integer.parseInt(str)
            if (isNegativeInteger(numberOfAttempts)) {
                throw new InvalidNumberOfAttemptsException();
            }
        } catch (NumberFormatException e) {
            throw new InvalidNumberOfAttemptsException();
        }
    }
    public static void validateRacingCars(String message) {
        if (!isLowerThanFive(message) || !hasMoreThanTwoStrings(message)) {
            throw new InvalidRacingCarsException();
        }
    }
    public static boolean isLowerThanFive(String message) {
        String[] parts = message.split(",");
        for (String part : parts) {
            if (part.length() > 5) {
                return false;
            }
        }
        return true;
    }
    public static boolean hasMoreThanTwoStrings(String message) {
        return message.split(",").length >= 2;
    }
    private static boolean isNegativeInteger(Integer integer) {
        return integer <= 0;
    }
}
