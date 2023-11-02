package racingcar.utils;

import racingcar.exception.ErrorMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CarNameValidator {
    public static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    public static final String CAR_NAME_DELIMITER = ",";

    public static List<String> validateCarNames(String input) {
        validateBlank(input);
        validateStartsOrEndsWith(input);
        List<String> names = Arrays.asList(input.split(CAR_NAME_DELIMITER));
        validateSize(names);
        validateLength(names);
        validateDuplicate(names);
        return names;
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
}
