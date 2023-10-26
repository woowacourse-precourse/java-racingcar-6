package racingcar.exception;

public class RacingGameException extends IllegalArgumentException {

    private RacingGameException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static RacingGameException of(ErrorMessage errorMessage) {
        return new RacingGameException(errorMessage);
    }
}
