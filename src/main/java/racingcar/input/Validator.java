package racingcar.input;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Validator {
    private static final int MINIMUM_CAR_NAME_LENGTH = 5;
    private static final Pattern NUMBERS_OLNY_PATTERN = Pattern.compile("[0-9]+");

    static void validateCarNames(String userInput) {
        String[] carNames = userInput.split(",");
        for (String carName : carNames) {
            if (carName.length() > MINIMUM_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(
                        "Car name '" + carName + "' should not exceed 5 characters.");
            }
        }
    }

    static void validateNumberOfAttempts(String userInput) {
        Matcher matcher = NUMBERS_OLNY_PATTERN.matcher(userInput);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(
                    "The number of attempts '" + userInput + "' should be a positive integer.");
        }
    }
}