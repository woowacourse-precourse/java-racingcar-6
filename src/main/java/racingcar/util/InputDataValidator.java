package racingcar.util;

public class InputDataValidator {

    public static void validateInputSize(String input) throws IllegalArgumentException {
        if (input.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateHasSpace(String input) throws IllegalArgumentException {
        if (input.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsInteger(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
