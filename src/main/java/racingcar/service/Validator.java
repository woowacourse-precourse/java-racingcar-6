package racingcar.service;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MAX_CAR_NAMES_LENGTH = 2;

    public String[] stringToArray(String carNamesInput) {
        if (!isCommasInclude(carNamesInput)) {
            throw new IllegalArgumentException();
        }
        return validateAndChangeToArray(carNamesInput);
    }

    public int stringToInt(String numberOfAttempts) {
        try {
            return Integer.parseInt(numberOfAttempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private String[] validateAndChangeToArray(String carNamesInput) {
        String[] carNames = dividedByCommas(carNamesInput);
        validateBlankCarNames(carNames);
        ignoreSpacing(carNames);
        if (!isUnder5digits(carNames) || isDuplicateCarName(carNames)) {
            throw new IllegalArgumentException();
        }
        return carNames;
    }

    private void validateBlankCarNames(String[] carNames) {
        if (carNames.length < MAX_CAR_NAMES_LENGTH) {
            throw new IllegalArgumentException();
        }
    }


    private boolean isCommasInclude(String carNamesInput) {
        return carNamesInput.contains(",");
    }

    private String[] dividedByCommas(String carNamesInput) {
        return carNamesInput.split(",");
    }

    private void ignoreSpacing(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            String replacedCarName = carNames[i].replaceAll(" ", "");
            validateBlankCarName(replacedCarName);
            carNames[i] = replacedCarName;
        }
    }

    private void validateBlankCarName(String carName) {
        if (carName.isBlank()) {
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
