package racingcar.exception;

public class RacingGameException extends IllegalArgumentException {

    public RacingGameException(ErrorMessage errorCode) {
        super(errorCode.getMessage());
    }
}