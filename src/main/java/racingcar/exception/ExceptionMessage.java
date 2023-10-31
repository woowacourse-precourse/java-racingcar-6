package racingcar.exception;

public enum ExceptionMessage {
    EMPTY_NAME("이름이 존재하지 않는 레이싱카가 존재합니다"),
    EMPTY_TRY_COUNT("시도 횟수가 입력되지 않았습니다"),
    CAR_NAME_MAX_LENGTH_EXCEEDED("레이싱카의 이름 입력의 최대 길이를 초과하셨습니다"),
    INVALID_INTEGER_FORMAT("입력된 문자가 정수로 변환되지 않습니다");

    private final String errorMessage;

    ExceptionMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
