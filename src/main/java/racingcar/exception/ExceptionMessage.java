package racingcar.exception;

public enum ExceptionMessage {
    CAR_NAME_MAX_LENGTH_EXCEEDED("레이싱카의 이름 입력의 최대 길이를 초과하셨습니다"),
    INVALID_INTEGER_FORMAT("입력된 문자가 정수로 변환되지 않습니다");

    private final String errorMessage;

    ExceptionMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(ExceptionMessage exceptionMessage) {
        return exceptionMessage.errorMessage;
    }
}
