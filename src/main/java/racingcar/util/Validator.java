package racingcar.util;

import static racingcar.constant.GameOptions.MAX_NAME_LENGTH;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static void validateCarName(String carName) {
        validateNotBlank(carName);
        validateFirstChar(carName);
        validateLastChar(carName);
        validateLength(carName);
    }

    public static void validateCarNames(List<String> carNames) {
        List<String> names = new ArrayList<>();
        for (String name : carNames) {
            if (names.contains(name)) {
                throw new IllegalArgumentException();
            }
            names.add(name);
        }
    }

    private static void validateNotBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateFirstChar(String carName) {
        boolean hasLeadingSpace = carName.startsWith(" ");
        if (hasLeadingSpace) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateLastChar(String carName) {
        boolean hasTrailingSpace = carName.endsWith(" ");
        if (hasTrailingSpace) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateLength(String carName) {
        boolean isOverLimit = carName.length() > MAX_NAME_LENGTH;
        if (isOverLimit) {
            throw new IllegalArgumentException();
        }
    }
}
