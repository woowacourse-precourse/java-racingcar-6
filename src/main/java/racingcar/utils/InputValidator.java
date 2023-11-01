package racingcar.utils;

import java.util.List;

public class InputValidator {

    public static void checkHasComma(String carNameInput) {
        boolean isContain = carNameInput.contains(",");

        if (!isContain) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkEndsWithComma(String carNameInput) {
        if (carNameInput.charAt(carNameInput.length() - 1) == ',') {
            throw new IllegalArgumentException();
        }
    }

    public static void checkLengthFive(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkBlankName(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.trim().isBlank()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkNumeric(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

}
