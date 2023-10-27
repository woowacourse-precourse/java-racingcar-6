package racingcar.exception;

public class CarNameDuplicateException extends IllegalArgumentException {
    public CarNameDuplicateException(String s) {
        super(s);
    }
}
