package racingcar.utils;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private InputValidator() {
    }

    public static void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > Constants.NAME_LENGTH_MAXIMUM) {
                throw new IllegalArgumentException(Constants.EXCEED_NAME_LENGTH);
            }
        }
        if (containsDuplicate(carNames)) {
            throw new IllegalArgumentException(Constants.DUPLICATE_CAR_NAMES);
        }
        if (isEmpty(carNames)) {
            throw new IllegalArgumentException(Constants.EMPTY_CAR_NAMES);
        }
    }

    public static void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(Constants.INVALID_TRY_COUNT);
        }
    }

    private static boolean containsDuplicate(String[] carNames) {
        Set<String> uniqueNames = new HashSet<>();
        for (String carName : carNames) {
            if (!uniqueNames.add(carName)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEmpty(String[] carNames) {
        for (String carName : carNames) {
            if (carName == null || (carName.trim().isEmpty() || carName.isBlank())) {
                return true;
            }
        }
        return false;
    }

    public static void validateCarNameWithComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(Constants.INVALID_CAR_NAMES);
        }
    }
}
