package racingcar.Exceptions;

public class CarNameMinLengthException extends IllegalArgumentException {
    public CarNameMinLengthException() {
        super("자동차 이름의 길이는 0보다 커야 합니다.");
    }
}
