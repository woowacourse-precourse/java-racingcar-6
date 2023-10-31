package racingcar.Exceptions;

public class CarNameMaxLengthException extends IllegalArgumentException {
    public CarNameMaxLengthException() {
        super("자동차 이름의 길이는 6보다 작아야 합니다.");
    }
}
