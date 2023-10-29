package racingcar.utils;

import static racingcar.model.constants.Error.DUPLICATE;
import static racingcar.model.constants.Error.LENGTH_INVALID;
import static racingcar.model.constants.Error.NON_COMMA;
import static racingcar.model.constants.Error.NUMBER_NOT_INTEGER;
import static racingcar.model.constants.Error.NUMBER_RANGE_INVALID;
import static racingcar.model.constants.Rule.CAR_MAX_LENGTH;
import static racingcar.model.constants.Rule.CAR_MIN_LENGTH;
import static racingcar.model.constants.Rule.DELIMITER;
import static racingcar.model.constants.Rule.TRIAL_MIN_LENGTH;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void validateCarName(String input) {
        validateComma(input);
        List<String> nameList = getCarNames(input);
        validateLength(nameList);
        validateDuplicates(nameList);
    }

    public static void validateTrial(String input) {
        validateIfInteger(input);
        int trial = getTrial(input);
        validateRange(trial);
    }

    private static void validateComma(String input) {
        if (!input.contains(DELIMITER.getMessage())) {
            throw new IllegalArgumentException(NON_COMMA.getMessage());
        }
    }

    private static void validateLength(List<String> inputList) {
        for (String carName : inputList) {
            if (carName.length() < CAR_MIN_LENGTH.getValue() || carName.length() > CAR_MAX_LENGTH.getValue()) {
                throw new IllegalArgumentException(LENGTH_INVALID.getMessage());
            }
        }
    }

    private static void validateDuplicates(List<String> inputList) {
        Set<String> set = new HashSet<>(inputList);
        if (set.size() != inputList.size()) {
            throw new IllegalArgumentException(DUPLICATE.getMessage());
        }
    }

    private static void validateIfInteger(String input) {
        if (input.chars().anyMatch(ch -> !Character.isDigit(ch))) {
            throw new IllegalArgumentException(NUMBER_NOT_INTEGER.getMessage());
        }
    }

    private static void validateRange(int input) {
        if (input < TRIAL_MIN_LENGTH.getValue()) {
            throw new IllegalArgumentException(NUMBER_RANGE_INVALID.getMessage());
        }
    }

    private static List<String> getCarNames(String input) {
        String[] names = input.trim().split(DELIMITER.getMessage());
        return Arrays.asList(names);
    }

    private static int getTrial(String input) {
        return Integer.parseInt(input);
    }
}
