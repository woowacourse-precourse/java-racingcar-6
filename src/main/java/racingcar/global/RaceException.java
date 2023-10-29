package racingcar.global;

public class RaceException extends IllegalArgumentException {
    private RaceException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static RaceException of(ErrorMessage errorMessage) {
        return new RaceException(errorMessage);
    }
}
