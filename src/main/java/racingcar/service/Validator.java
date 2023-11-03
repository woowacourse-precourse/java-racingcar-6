package racingcar.service;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MAX_CAR_NAMES_LENGTH = 2;

    public String[] stringToArray(String carNamesInput) {
        validateCommasInclude(carNamesInput);
        return validateAndChangeToArray(carNamesInput);
    }

    private void validateCommasInclude(String carNamesInput) {
        if (!carNamesInput.contains(",")) {
            throw new IllegalArgumentException();
        }
    }

    public int stringToInt(String numberOfAttempts) {
        validateNullOrBlank(numberOfAttempts);
        validateNumeric(numberOfAttempts);
        return validatePositiveNumber(numberOfAttempts);
    }

    private int validatePositiveNumber(String numberOfAttempts) {
        int attemptCount = Integer.parseInt(numberOfAttempts);
        if (attemptCount <= 0) {
            throw new IllegalArgumentException();
        }
        return attemptCount;
    }

    private void validateNumeric(String numberOfAttempts) {
        for (char numberOfAttemptsChar : numberOfAttempts.toCharArray()) {
            if (!Character.isDigit(numberOfAttemptsChar)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private String[] validateAndChangeToArray(String carNamesInput) {
        String[] carNames = dividedByCommas(carNamesInput);
        validateBlankCarNames(carNames);
        ignoreSpacing(carNames);
        if (isCarNamesValid(carNames)) {
            throw new IllegalArgumentException();
        }
        return carNames;
    }

    private boolean isCarNamesValid(String[] carNames) {
        return !isUnder5digits(carNames) || isDuplicateCarName(carNames);
    }

    private void validateBlankCarNames(String[] carNames) {
        if (carNames.length < MAX_CAR_NAMES_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private String[] dividedByCommas(String carNamesInput) {
        return carNamesInput.split(",");
    }

    private void ignoreSpacing(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            String replacedCarName = carNames[i].replaceAll(" ", "");
            validateNullOrBlank(replacedCarName);
            carNames[i] = replacedCarName;
        }
    }

    private void validateNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isUnder5digits(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                return false;
            }
        }
        return true;
    }

    private boolean isDuplicateCarName(String[] carNames) {
        List<String> cars = new ArrayList<>();
        for (String carName : carNames) {
            if (cars.contains(carName)) {
                return true;
            }
            cars.add(carName);
        }
        return false;
    }
}
