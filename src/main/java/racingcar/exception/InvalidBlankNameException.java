package racingcar.exception;

public class InvalidBlankNameException extends IllegalArgumentException{
    private static final String INVALID_BLANK_NAME_MESSAGE = "[에러] 입력된 이름이 비어있습니다.";

    public InvalidBlankNameException() {
        super(INVALID_BLANK_NAME_MESSAGE);
    }
}
