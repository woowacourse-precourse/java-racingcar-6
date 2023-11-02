package racingcar.utils;

import racingcar.constants.ErrorMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static racingcar.constants.CarNameConstants.*;

public class Validator {
    public static List<String> validateCarNames(String input) {
        validateBlank(input);
        validateStartsOrEndsWith(input);
        List<String> names = Arrays.asList(input.split(CAR_NAME_DELIMITER));
        validateSize(names);
        validateLength(names);
        validateDuplicate(names);
        return names;
    }

    public static int validateTotalRound(String input) {
        int totalRound = validateNumeric(input);
        validateIfZero(totalRound);
        return totalRound;
    }

    private static void validateSize(List<String> names) {
        if (names.size() == 1) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_CAR_SIZE_ERROR.getMessage());
        }
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_BLANK_ERROR.getMessage());
        }
    }

    private static void validateStartsOrEndsWith(String input) {
        if (input.startsWith(CAR_NAME_DELIMITER) || input.endsWith(CAR_NAME_DELIMITER)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DELIMITER_ERROR.getMessage());
        }
    }

    private static void validateLength(List<String> names) {
        for (String name : names) {
            if (name.isBlank()) {
                throw new IllegalArgumentException(ErrorMessage.CAR_NAME_MINIMUM_LENGTH_ERROR.getMessage());
            }
            if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_EXCEEDED_ERROR.getMessage());
            }
        }
    }

    private static void validateDuplicate(List<String> names) {
        HashSet<String> namesToSet = new HashSet<>(names);
        if (names.size() != namesToSet.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME_ERROR.getMessage());
        }
    }

    private static int validateNumeric(String input) {
        int totalRound;
        try {
            totalRound = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TOTAL_ROUND_ERROR.getMessage());
        }
        return totalRound;
    }

    private static void validateIfZero(int totalRound) {
        if (totalRound == 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TOTAL_ROUND_ERROR.getMessage());
        }
    }
}
