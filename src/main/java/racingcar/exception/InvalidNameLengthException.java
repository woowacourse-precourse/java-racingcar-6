package racingcar.exception;

public class InvalidNameLengthException extends IllegalArgumentException{
    private static final String INVALID_NAME_LENGTH_MESSAGE = "[에러] 이름의 길이가 5자를 넘습니다.";

    public InvalidNameLengthException() {
        super(INVALID_NAME_LENGTH_MESSAGE);
    }
}
