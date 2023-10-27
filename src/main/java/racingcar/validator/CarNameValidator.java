package racingcar.validator;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {
    private static final String COMMA = ",";
    private static final String EMPTY = "";
    private static final String BLANK = " ";
    private static final String NOT_COMMA_AND_ALLOW_BLANK_BETWEEN_NAME = ".*[^,\\s^a-zA-Z0-9^[가-힣]*$].*";
    private static final String BLANK_IN_START = "^\\s.*";
    private static final String BLANK_IN_END = ".*\\s$";
    private static final int MAX_RANGE = 5;
    private static final int MIM_RANGE = 1;

    private CarNameValidator() {
    }

    public static void validate(String input) {
        validateNull(input);
        validateSeparator(input);
        validateCarName(input);
    }

    private static void validateNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_ERROR);
        }
    }

    private static void validateSeparator(String input) {
        if (input.matches(NOT_COMMA_AND_ALLOW_BLANK_BETWEEN_NAME)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_COMMA);
        }
    }

    private static void validateCarName(String input) {
        String[] carNames = input.split(COMMA);
        Set<String> nameSet = new HashSet<>();
        for (String carName : carNames) {
            validateCarNameLength(carName);
            validateCarNameIsBlank(carName);
            validateIsStartBlank(carName);
            validateIsEndBlank(carName);
            nameSet.add(carName);
        }
        validateDuplication(nameSet.size(), carNames.length);
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > MAX_RANGE || carName.length() < MIM_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.NAME_BETWEEN_ONE_AND_FIVE);
        }
    }

    private static void validateCarNameIsBlank(String carName) {
        if (carName.equals(BLANK)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_NAME_REPLACED_BLANK);
        }
    }

    private static void validateIsStartBlank(String carName) {
        if (carName.matches(BLANK_IN_START)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_BLANK_IN_START);
        }
    }

    private static void validateIsEndBlank(String carName) {
        if (carName.matches(BLANK_IN_END)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_BLANK_IN_END);
        }
    }

    private static void validateDuplication(int nameSetSize, int carCount) {
        if (nameSetSize != carCount) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_NAME_DUPLICATION);
        }
    }
}
