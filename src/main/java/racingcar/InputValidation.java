package racingcar;

public class InputValidation {
    public static void containsNumber(String input) throws IllegalArgumentException {
        if (input.matches(".*\\d.*")) {
            throw new IllegalArgumentException();
        }
    }
}