package racingcar.exception;

public class InvalidNumberFormatException extends IllegalArgumentException{
    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "[에러] 입력된 값이 숫자형식이 아닙니다.";

    public InvalidNumberFormatException() {
        super(INVALID_NUMBER_FORMAT_MESSAGE);
    }
}
