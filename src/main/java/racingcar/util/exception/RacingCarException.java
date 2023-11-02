package racingcar.util.exception;

public class RacingCarException extends IllegalArgumentException {

    private RacingCarException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static RacingCarException of(ErrorMessage errorMessage) {
        return new RacingCarException(errorMessage);
    }
}
