package racingcar.validation;

import racingcar.constant.GameConfig;

public class InputValidator {

    public InputValidator() {
    }

    public static void validateInputName(String name) {
        validateInputNameLength(name);
        validateNoBlank(name);
    }

    public static void validateNumericInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNoBlank(String name) {
        String noBlankName = name.replace(" ", "");
        if (name.length() != noBlankName.length()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateInputNameLength(String name) {
        if (name.isEmpty() || name.length() > GameConfig.MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

}
