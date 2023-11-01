package racingcar.validation;

public class InputValidator {

    public InputValidator() {
    }

    public static void validateInputName(String name, int maxLength) {
        validateInputNameLength(name, maxLength);
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
        if (name.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateInputNameLength(String name, int maxLength) {
        if (name.isEmpty() || name.length() > maxLength) {
            throw new IllegalArgumentException();
        }
    }

}
