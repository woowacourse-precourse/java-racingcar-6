package racingcar.exception;

public class OnlyCommaInputException extends IllegalArgumentException {
    private static final String ONLY_COMMA_NOT_ALLOWED_MESSAGE = "쉼표(,)만 입력할 수 없습니다.";

    public OnlyCommaInputException() {
        super(ONLY_COMMA_NOT_ALLOWED_MESSAGE);
    }
}
