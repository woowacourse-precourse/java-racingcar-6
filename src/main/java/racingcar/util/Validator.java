package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.util.ErrorMessage.*;

public class Validator {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final String NOT_SPECIAL_REGEX = "[^a-zA-Z0-9가-힣]";

    private Validator() {}

    public static void validateName(String name) {
        checkBlank(name);
        checkLength(name);
        checkNumeric(name);
    }

    private static void checkBlank(String name) {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException(BLANK_ERROR.getMessage());
        }
    }

    private static void checkLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR.getMessage());
        }
    }

    private static void checkNumeric(String name) {
        if (name.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(NO_NUMERIC_ERROR.getMessage());
        }
    }

    public static void checkCount(int count) {
        checkPositive(count);
        checkMax(count);
    }

    private static void checkPositive(int count) {
        if (isNotPositive(count)) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR.getMessage());
        }
    }

    private static boolean isNotPositive(int count) {
        return count <= 0;
    }

    private static void checkMax(int count) {
        if (count >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR.getMessage());
        }
    }

    public static void checkSplitUnit(String input) {
        if (!input.matches(NOT_SPECIAL_REGEX)) {
            throw new IllegalArgumentException(SPLIT_REGEX_ERROR.getMessage());
        }
    }

    public static void checkDuplicateName(String[] split) {
        int inputSize = split.length;
        Set<String> temp = new HashSet<>(List.of(split));
        if (inputSize != temp.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR.getMessage());
        }
    }

}
