package racingcar.exception;

public class UserTryNumberInputException extends IllegalArgumentException{
    public UserTryNumberInputException(String errorMessage) {
        super(errorMessage);
    }

    public UserTryNumberInputException() {
        super();
    }
}
