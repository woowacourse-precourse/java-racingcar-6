package racingcar.exception;

public class InvalidApplicantCarListException extends IllegalArgumentException{
    public InvalidApplicantCarListException(String exceptionHandlingCode) {
        super(exceptionHandlingCode);
    }
}
