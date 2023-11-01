package racingcar.utils;

import java.util.List;

public class InputValidator {

    private static final int CAR_NAME_MAXIMUM_LENGTH = 5;

    public static void checkTryNum(String tryCount) {
        InputValidator.checkNumeric(tryCount);
        InputValidator.checkZeroOrNegativeNumber(tryCount);
    }

    public static void checkCarName(List<String> carNames) {
        InputValidator.checkLengthFive(carNames);
        InputValidator.checkBlankName(carNames);
    }

    public static void checkCarNameInput(String carNameInput) {
        InputValidator.checkHasComma(carNameInput);
        InputValidator.checkEndsWithComma(carNameInput);
    }

    private static void checkHasComma(String carNameInput) {
        boolean isContain = carNameInput.contains(",");

        if (!isContain) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkEndsWithComma(String carNameInput) {
        if (carNameInput.charAt(carNameInput.length() - 1) == ',') {
            throw new IllegalArgumentException();
        }
    }

    private static void checkLengthFive(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > CAR_NAME_MAXIMUM_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void checkBlankName(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.trim().isBlank()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void checkNumeric(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void checkZeroOrNegativeNumber(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException();
        }
    }

}
