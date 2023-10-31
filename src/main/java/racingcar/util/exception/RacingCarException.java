package racingcar.util.exception;

public class RacingCarException extends IllegalArgumentException {
    private RacingCarException(final ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
    public static RacingCarException of(final ErrorMessage errorMessage) {
        return new RacingCarException(errorMessage);
    }
}
