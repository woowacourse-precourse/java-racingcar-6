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
        if (input.replaceAll("\\s", "").length() > 5) {
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
        if (!Pattern.matches("^(0*[1-9][0-9]*)$", input)) {
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
        if (!Pattern.matches("^[^,]+(,[^,]+)*$", input)) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_NOT_VALID);
        }
    }
}
