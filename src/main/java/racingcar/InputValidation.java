package racingcar;

public class InputValidation {
    public static void validateInput(String input) throws IllegalArgumentException {
        if (!input.matches("^[a-zA-Z,]*$")) {
            throw new IllegalArgumentException();
        }
        if (isEmpty(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }
}