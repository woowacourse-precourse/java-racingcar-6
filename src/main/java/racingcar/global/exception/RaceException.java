package racingcar.global.exception;

public class RaceException extends IllegalArgumentException {
    private RaceException(final ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static RaceException of(final ErrorMessage errorMessage) {
        return new RaceException(errorMessage);
    }
}
