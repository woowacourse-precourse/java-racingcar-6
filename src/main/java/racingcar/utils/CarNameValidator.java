package racingcar.utils;

import racingcar.exception.ErrorMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {
    private static final int MINIMUM_CAR_NAMES = 2;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_DELIMITER = ",";

    public static void validateCarNamesInput(String input) {
        validateBlank(input);
        validateStartsOrEndsWith(input);
        validateSize(input);
        validateDuplicate(input);
    }

    public static void validateCarName(String carName) {
        validateIfBlank(carName);
        validateLength(carName);
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

    private static void validateSize(String input) {
        if (input.split(CAR_NAME_DELIMITER).length < MINIMUM_CAR_NAMES) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_CAR_NAME_NUMBER_ERROR.getMessage());
        }
    }

    private static void validateDuplicate(String input) {
        List<String> carNamesInput = Arrays.asList(input.split(CAR_NAME_DELIMITER));
        Set<String> uniqueNames = new HashSet<>(carNamesInput);
        if (carNamesInput.size() != uniqueNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME_ERROR.getMessage());
        }
    }

    private static void validateIfBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_MINIMUM_LENGTH_ERROR.getMessage());
        }
    }

    private static void validateLength(String name) {
        if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_EXCEEDED_ERROR.getMessage());
        }
    }
}
