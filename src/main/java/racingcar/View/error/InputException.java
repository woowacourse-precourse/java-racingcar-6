package racingcar.View.error;

public class InputException extends IllegalArgumentException {

    public InputException(Error error) {
        super(error.message);
    }
}
