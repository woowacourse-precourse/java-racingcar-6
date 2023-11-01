package racingcar.util.exception;

public class RacingException extends IllegalArgumentException {
    private RacingException(final ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static RacingException of(final ErrorMessage errorMessage) {
        return new RacingException(errorMessage);
    }
}
