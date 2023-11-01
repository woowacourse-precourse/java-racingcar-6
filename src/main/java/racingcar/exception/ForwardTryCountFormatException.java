package racingcar.exception;

public class ForwardTryCountFormatException extends IllegalArgumentException {
    public static final String ERROR_MESSAGE = "전진 횟수는 입력할 때에는 자연수를 입력해주세요.";

    public ForwardTryCountFormatException() {
        super(ERROR_MESSAGE);
    }
}
