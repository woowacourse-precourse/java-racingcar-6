package racingcar.exception;

public class Exception extends IllegalArgumentException {

    private Error error;
    public Exception(Error error) {
        super(error.getMsg());
    }
}
