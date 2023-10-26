package racingcar.exception.console_input;

public class CanNotConvertToIntInputException extends IllegalArgumentException {

    public CanNotConvertToIntInputException(final String message) {
        super(message + "을(를) 숫자로 변환할 수 없습니다.");
    }
}
