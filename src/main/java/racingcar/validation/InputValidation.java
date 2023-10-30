package racingcar.validation;

public abstract class InputValidation {

    public static Boolean isEmptyInput(String input) {
        if (input.trim().equals("")) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
