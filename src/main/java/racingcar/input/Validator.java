package racingcar.input;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Validator {
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final Pattern NUMBERS_ONLY_PATTERN = Pattern.compile("[0-9]+");

    static void validateCarNames(String userInput) {
        Arrays.stream(userInput.split(","))
                .filter(carName -> carName.length() > MAXIMUM_CAR_NAME_LENGTH)
                .findAny()
                .ifPresent(carName -> {
                    throw new IllegalArgumentException("Car name '" + carName + "' should not exceed 5 characters.");
                });
    }

    static void validateNumberOfAttempts(String userInput) {
        Matcher matcher = NUMBERS_ONLY_PATTERN.matcher(userInput);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(
                    "The number of attempts '" + userInput + "' should be a positive integer.");
        }
    }
}