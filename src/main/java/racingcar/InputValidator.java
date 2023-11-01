package racingcar;

import static racingcar.MessageManager.*;

public class InputValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validateInputCarName(String inputCarName) {
        String[] carName = inputCarName.split(",");

        validateContainsCommaAndBlank(inputCarName);
        validateContainsCommaSeparator(inputCarName);
        validateStringLengthInArray(carName);
    }

    public static void validateInput(String countNumber) throws IllegalArgumentException {
        validateNonInteger(countNumber);
        validateNonPositive(countNumber);
    }

    public static void validateNonInteger(String input) {
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(getNonIntegerNumberMessage());
        }
    }

    public static void validateNonPositive(String input) {
        int number = Integer.parseInt(input);

        if (number <= 0) {
            throw new IllegalArgumentException(getNonPositiveNumberMessage());
            }
    }



    public static void validateContainsCommaSeparator(String input) {
        if (!containsCommaSeparator(input)) {
            throw new IllegalArgumentException(getCommaSeparatorMissingMessage());
        }
    }

    private static boolean containsCommaSeparator(String input) {
        return input.contains(",");
    }

    public static void validateContainsCommaAndBlank(String input) {
        if (containsCommaAndBlank(input)) {
            throw new IllegalArgumentException(getContainsCommaAndBlankMessage());
        }
    }

    private static boolean containsCommaAndBlank(String input) {
        return input.contains(", ");
    }

    public static void validateStringLengthInArray(String[] strings) throws IllegalArgumentException {
        for (String string : strings) {
            validateStringLength(string);
        }
    }

    public static void validateStringLength(String string) throws IllegalArgumentException {
        if (isStringTooLong(string)) {
            throw new IllegalArgumentException(getStringTooLongMessage());
        }
    }

    public static boolean isStringTooLong(String string) {
        return string.length() > MAX_CAR_NAME_LENGTH;
    }
}
