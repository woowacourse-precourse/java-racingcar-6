package racingcar.Exceptions;

public class CarNameDuplicationException extends IllegalArgumentException {
    public CarNameDuplicationException() {
        super("중복된 자동차 이름을 입력하셨습니다.");
    }
}
