package racingcar.util.exception;

public class RacingGameException extends IllegalArgumentException {
    private RacingGameException(final ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static RacingGameException of(final ErrorMessage errorMessage) {
        return new RacingGameException(errorMessage);
    }
}
