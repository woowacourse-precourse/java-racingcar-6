package racingcar.exception;

public class CarNameIncorrectException extends IllegalArgumentException {
    public CarNameIncorrectException(String s) {
        super(s);
    }
}
