package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Validator {

    public static String[] isValidCarName(String[] inputs) {
        for (String input : inputs) {
            isLengthLessThanFive(input);
        }
        isDuplicateName(inputs);
        return inputs;
    }

    public static String isValidAttemptCount(String input) {
        isEmpty(input);
        isOneOrMore(input);
        isInRangeOfInt(input);
        return input;
    }

    public static void isEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_VALUE);
        }
    }

    public static void isLengthLessThanFive(String input) {
        if (input
                .replaceAll(Constants.SPACE_REMOVAL_REGEX, Constants.REPLACEMENT_STRING_REGEX)
                .length() > Constants.MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NAME_LENGTH_MAX_5);
        }
    }

    public static void isDuplicateName(String[] inputs) {
        List<String> names = new ArrayList<>();
        for (String input : inputs) {
            if (names.contains(input)) {
                throw new IllegalArgumentException(ExceptionMessage.INPUT_NON_DUPLICATE_CAR_NAME);
            }
            names.add(input);
        }
    }

    public static void isOneOrMore(String input) {
        if (!Pattern.matches(Constants.NUMBER_PATTERN, input)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_ONE_OR_HIGHER_REQUIRED);
        }
    }

    public static void isInRangeOfInt(String input) {
        long number = Long.parseLong(input);
        if (number > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_IN_INT_RANGE);
        }
    }

    public static void isValidInput(String input) {
        isEmpty(input);
        isValidName(input);
    }

    public static void isValidName(String input) {
        if (!Pattern.matches(Constants.COMMA_SEPARATED_PATTERN, input)) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_NOT_VALID);
        }
    }
}
