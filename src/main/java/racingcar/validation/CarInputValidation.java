package racingcar.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import racingcar.utils.Constants;
import racingcar.utils.ErrorMessage;
import racingcar.utils.Util;

public class CarInputValidation {
    public void validateCarInput(String input) {
        validateDuplicateNames(input);
        validateNoSpaces(input);
        validateNameLength(input);
        validateMinCarCount(input);
        validateTrailingComma(input);
        validateCaseRedundancy(input);
        validateSpecialCharacters(input);
    }

    private void validateDuplicateNames(String input) {
        String[] inputCars = input.split(Util.CAR_NAME_DELIMITER);
        Set<String> names = new HashSet<>(Arrays.asList(inputCars));
        if (names.size() < inputCars.length) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME_ERROR_MESSAGE);
        }
    }

    private void validateNoSpaces(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.NAME_CONTAINS_WHITESPACE_ERROR_MESSAGE);
        }
    }

    private void validateNameLength(String input) {
        String[] inputCars = input.split(Util.CAR_NAME_DELIMITER);
        for (String name : inputCars) {
            if (name.length() < Constants.MIN_CAR_NAME_LENGTH || name.length() > Constants.MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_OUT_OF_RANGE_ERROR_MESSAGE);
            }
        }
    }

    private void validateMinCarCount(String input) {
        String[] inputCars = input.split(Util.CAR_NAME_DELIMITER);
        if (inputCars.length < Constants.MIN_CAR_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LESS_THAN_MINIMUM_CAR_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateTrailingComma(String input) {
        if (input.endsWith(Util.CAR_NAME_DELIMITER)) {
            throw new IllegalArgumentException(ErrorMessage.COMMA_AT_END_ERROR_MESSAGE);
        }
    }

    private void validateCaseRedundancy(String input) {
        String[] inputCars = input.split(Util.CAR_NAME_DELIMITER);
        Set<String> names = new HashSet<>();
        for (String name : inputCars) {
            String normalizedName = name.toLowerCase();
            if (names.contains(normalizedName)) {
                throw new IllegalArgumentException(ErrorMessage.CASE_INSENSITIVE_DUPLICATE_ERROR_MESSAGE);
            }
        }
    }

    private void validateSpecialCharacters(String input) {
        String[] inputCars = input.split(Util.CAR_NAME_DELIMITER);
        for (String name : inputCars) {
            if (!Pattern.matches(Constants.ALPHANUMERIC_HYPHEN_UNDERSCORE_PERIOD_REGEX, name)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_CHARACTERS_ERROR_MESSAGE);
            }
        }
    }
}