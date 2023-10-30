package racingcar.validation;

public abstract class InputValidation {

    public static void isEmptyInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
