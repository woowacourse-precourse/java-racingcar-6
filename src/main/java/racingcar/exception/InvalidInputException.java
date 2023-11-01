package racingcar.exception;

public class InvalidInputException extends IllegalArgumentException {

    private InvalidInputException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static InvalidInputException with(ErrorMessage errorMessage) {
        return new InvalidInputException(errorMessage);
    }
}
