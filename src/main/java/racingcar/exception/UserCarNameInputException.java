package racingcar.exception;

public class UserCarNameInputException extends IllegalArgumentException{

    public UserCarNameInputException(String errorMessage) {
        super(errorMessage);
    }

    public UserCarNameInputException() {
        super();
    }
}
