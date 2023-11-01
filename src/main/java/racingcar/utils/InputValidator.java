package racingcar.utils;

import java.util.List;

public class InputValidator {

    private static final String NUMBER_REGEX = "^[1-9]\\d*$";
    private static final int MAX_NAME_LENGTH = 5;

    public static List<String> validateCarNames(String names) {
        List<String> carNames = List.of(names.trim().split(","));
        carNames.forEach(InputValidator::validateCarName);
        return carNames;
    }

    public static int validateTryCountIsNumber(String count) {
        if (isNumber(count)) {
            return Integer.parseInt(count);
        }

        throw new IllegalArgumentException();
    }

    private static boolean isNumber(String count) {
        return count.matches(NUMBER_REGEX);
    }

    private static void validateCarName(String name) {
        if (!validateNameLength(name)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean validateNameLength(String name) {
        return !name.isEmpty() && name.length() <= MAX_NAME_LENGTH;
    }
}
