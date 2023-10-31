package racingcar.exception.car;

public class OnlyCommaInputException extends IllegalArgumentException {
    private static final String ONLY_COMMA_NOT_ALLOWED_MESSAGE = "쉼표(,)사이에 이름을 입력해주세요.";

    public OnlyCommaInputException() {
        super(ONLY_COMMA_NOT_ALLOWED_MESSAGE);
    }
}
