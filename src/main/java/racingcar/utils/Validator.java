package racingcar.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static void checkNameInput(String nameInput) {
        checkNull(nameInput);
        checkSpaces(nameInput);
        checkDuplicateNames(nameInput);
        checkNameLength(nameInput);
        checkMinimumNameCount(nameInput);
    }

    private static void checkSpaces(String nameInput) {
        if (nameInput.strip().isEmpty()) {
            throw new IllegalArgumentException(Message.BLANK_ERROR_MESSAGE);
        }
    }

    private static void checkNull(String nameInput) {
        if (nameInput == null) {
            throw new IllegalArgumentException(Message.NULL_ERROR_MESSAGE);
        }
    }

    private static void checkDuplicateNames(String nameInput) {
        String[] names = nameInput.split(Constant.DELIMITER);
        Set<String> nameSet = new HashSet<>(Arrays.asList(names));
        if (nameSet.size() != names.length) {
            throw new IllegalArgumentException(Message.DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }

    private static void checkNameLength(String nameInput) {
        String[] names = nameInput.split(Constant.DELIMITER);
        for (String name : names) {
            if (name.length() > Constant.MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(Message.NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }

    private static void checkMinimumNameCount(String nameInput) {
        String[] names = nameInput.split(Constant.DELIMITER);
        if (names.length < Constant.MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(Message.MINIMUM_NUMBER_INPUTS_MESSAGE);
        }
    }

    public static void checkAttemptsCount(String attemptsInput) {
        checkNull(attemptsInput);
        checkIsNumber(attemptsInput);
        checkPositiveNumber(attemptsInput);
    }

    private static void checkIsNumber(String attemptsInput) {
        try {
            Integer.parseInt(attemptsInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void checkPositiveNumber(String attemptsInput) {
        int attempts = Integer.parseInt(attemptsInput);
        if (attempts < 1) {
            throw new IllegalArgumentException(Message.NOT_POSITIVE_NUMBER_ERROR_MESSAGE);
        }
    }
}
