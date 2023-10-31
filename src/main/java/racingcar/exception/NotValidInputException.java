package racingcar.exception;

// 유효하지 않은 값을 입력하는 경우 IllegalArgumentException을 상속받는 NotValidInputException 발생
public class NotValidInputException extends IllegalArgumentException {
    public NotValidInputException(String message) {
        super(message);
    }
}