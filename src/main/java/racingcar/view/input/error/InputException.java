package racingcar.view.input.error;

public class InputException extends IllegalArgumentException {

    public InputException(InputError inputError) {
        super(inputError.message);
    }
}
