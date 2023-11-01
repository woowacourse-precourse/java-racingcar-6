package racingcar.input;

public class InvalidInputException extends IllegalArgumentException {
    public InvalidInputException(String errorMessage) {
        super(String.format("[ERROR] %s", errorMessage));
    }
}
