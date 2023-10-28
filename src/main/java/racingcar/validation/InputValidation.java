package racingcar.validation;

import java.util.regex.Pattern;

public class InputValidation {

    static final int CAR_NAME_MAX_LENGTH = 5;
    static final String REGEXP_PATTERN_ZERO_TO_NINE_NUMBER = "^[0-9]*$";

    public static void validateCarsName(String[] split) {
        for (String carName : split) {
            validateBlankCarName(carName);
            validateCarNameLength(carName);
        }
    }

    private static void validateBlankCarName(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateTimes(String timesStr) {
        if (!isContainsOnlyZeroToNine(timesStr)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isContainsOnlyZeroToNine(String timesStr) {
        return Pattern.matches(REGEXP_PATTERN_ZERO_TO_NINE_NUMBER, timesStr);
    }
}
