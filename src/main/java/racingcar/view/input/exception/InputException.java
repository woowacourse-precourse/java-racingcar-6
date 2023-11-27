package racingcar.view.input.exception;

public class InputException extends IllegalArgumentException {
    private InputException(String message) {
        super(message);
    }

    public static InputException of(String message) {
        return new InputException(message);
    }
}