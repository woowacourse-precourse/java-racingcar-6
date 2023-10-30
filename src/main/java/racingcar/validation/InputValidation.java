package racingcar.validation;

public abstract class InputValidation {

    public static Boolean isEmptyInput(String input) {
        return input.isBlank();
    }
}
