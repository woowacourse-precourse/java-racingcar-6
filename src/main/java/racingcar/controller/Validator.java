package racingcar.controller;

import static racingcar.view.messages.ErrorMessages.ERROR_CAR_NAMES_BLANK;
import static racingcar.view.messages.ErrorMessages.ERROR_CAR_NAMES_LENGTH;
import static racingcar.view.messages.ErrorMessages.ERROR_CAR_NAMES_UNIQUE;
import static racingcar.view.messages.ErrorMessages.ERROR_TRY_COUNT_NUMERIC;
import static racingcar.view.messages.ErrorMessages.ERROR_TRY_COUNT_RANGE;

import java.util.HashSet;
import java.util.List;

public class Validator {
    public static void validateCarNames(List<String> carNames) {
//        validateCarNamesBlank(carNames);
//        validateCarNamesLength(carNames);
        validateCarNamesUnique(carNames);
    }

    public static void validateTryCount(String tryCount) {
        validateTryCountNumeric(tryCount);
        validateTryCountRange(tryCount);
    }

//    private static void validateCarNamesBlank(List<String> carNames) {
//        if (carNames.stream().anyMatch(String::isBlank)) {
//            throw new IllegalArgumentException(ERROR_CAR_NAMES_BLANK.getErrorMessage());
//        }
//    }

//    private static void validateCarNamesLength(List<String> carNames) {
//        if (carNames.stream().anyMatch(name -> name.length() > 5)) {
//            throw new IllegalArgumentException(ERROR_CAR_NAMES_LENGTH.getErrorMessage());
//        }
//    }

    private static void validateCarNamesUnique(List<String> carName) {
        if (carName.size() != new HashSet<>(carName).size()) {
            throw new IllegalArgumentException(ERROR_CAR_NAMES_UNIQUE.getErrorMessage());
        }
    }

    private static void validateTryCountNumeric(String tryCount) {
        if (!tryCount.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(ERROR_TRY_COUNT_NUMERIC.getErrorMessage());
        }
    }

    private static void validateTryCountRange(String tryCount) {
        if (Integer.parseInt(tryCount) < 1) {
            throw new IllegalArgumentException(ERROR_TRY_COUNT_RANGE.getErrorMessage());
        }
    }
}
