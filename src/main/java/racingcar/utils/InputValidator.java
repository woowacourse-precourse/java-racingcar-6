package racingcar.utils;

import java.util.List;

public class InputValidator {

    public static void readCarNames(String names) {
        List<String> carNames = List.of(names.trim().split(","));
        carNames.forEach(InputValidator::validateCarName);
    }

    private static void validateCarName(String name) {
        if (validateNameLength(name)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean validateNameLength(String name) {
        return !name.isEmpty() && name.length() <= 5;
    }
}
