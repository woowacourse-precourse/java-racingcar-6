package racingcar.validation;

import racingcar.constant.GameConfig;

public class InputValidator {

    public InputValidator() {
    }

    public static void validateInputNameLength(String name) {
        if (name.length() > GameConfig.MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumericInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
