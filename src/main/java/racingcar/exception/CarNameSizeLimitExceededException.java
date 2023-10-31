package racingcar.exception;

public class CarNameSizeLimitExceededException extends IllegalArgumentException {
    public CarNameSizeLimitExceededException(String s) {
        super(s);
    }
}
