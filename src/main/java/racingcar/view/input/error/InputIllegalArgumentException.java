package racingcar.view.input.error;

public class InputIllegalArgumentException extends IllegalArgumentException {

    public InputIllegalArgumentException(InputError inputError) {
        super(inputError.message);
    }
}
