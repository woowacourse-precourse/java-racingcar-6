package racingcar.exception;

public class RacingCarException extends IllegalArgumentException {
    public RacingCarException(final ExceptionMessages exceptionMessages) {
        super(exceptionMessages.getMessage());
    }

    public static RacingCarException of(final ExceptionMessages exceptionMessages) {
        return new RacingCarException(exceptionMessages);
    }
}
