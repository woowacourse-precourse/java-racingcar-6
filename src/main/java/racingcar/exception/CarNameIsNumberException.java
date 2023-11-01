package racingcar.exception;

public class CarNameIsNumberException extends IllegalArgumentException{
    public CarNameIsNumberException(String message) {
        super(message);
    }
}
