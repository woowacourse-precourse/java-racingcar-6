package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RaceInfoValidator {


    public static void checkCarNameLength(String[] carNames) throws IllegalArgumentException {
        for (String carName : carNames) {
            if (carName.length() > Constants.NAME_LENGTH_MAX) {
                throw new IllegalArgumentException(Constants.EXCEED_NAME_LENGTH);
            }
        }

    }

    public static void isNameEmpty(String[] carNames) throws IllegalArgumentException {
        for (String carName : carNames) {
            if (carName.isBlank()) {
                throw new IllegalArgumentException(Constants.EMPTY_CAR_NAME);
            }
        }
    }

    public static void hasUniqueName(String[] carNames) throws IllegalArgumentException {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(carNames));
        if (uniqueNames.size() != carNames.length) {
            throw new IllegalArgumentException(Constants.DUPLICATE_CAR_NAME);
        }
    }


    public static void hasMultipleCars(String[] carNames) throws IllegalArgumentException {
        if (carNames.length <= 1) {
            throw new IllegalArgumentException(Constants.CAR_COUNT_INSUFFICIENT);
        }
    }


    public static void checkAttemptCount(String attemptCount) throws IllegalArgumentException {
        try {
            Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.INVALID_ATTEMPT_COUNT);
        }

        if (Integer.parseInt(attemptCount) < 1) {
            throw new IllegalArgumentException(Constants.INVALID_ATTEMPT_COUNT);
        }
    }
}
