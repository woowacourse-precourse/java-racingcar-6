package racingcar.exception;

public class TrialNumberInvalidException extends IllegalArgumentException {

    private static final String exceptionMessage = "시도할 횟수는 숫자만 입력할 수 있습니다.";

    public TrialNumberInvalidException() {
        super(exceptionMessage);
    }
}
