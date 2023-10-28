package racingcar.exception;

public class InputException extends IllegalArgumentException {

    public InputException(InputErrorCode errorCode) {
        super(errorCode.getMessage());
    }

}
