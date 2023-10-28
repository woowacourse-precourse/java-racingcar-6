package racingcar.domain.input.error;

public class InputException extends IllegalArgumentException {

    public InputException(String inputValue, InputError inputError) {
        super(inputValue + inputError.message);
    }

    public InputException(InputError inputError) {
        super(inputError.message);
    }
}
