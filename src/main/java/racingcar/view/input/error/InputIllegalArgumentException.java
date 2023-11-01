package racingcar.view.input.error;

public class InputIllegalArgumentException extends IllegalArgumentException {

    public InputIllegalArgumentException(InputError inputError) {
        super(inputError.message);
    }

    public InputIllegalArgumentException(InputError inputError, int max, int min) {
        super(String.format(inputError.message, max, min));
    }
}
