package racingcar.enums;

public enum ExceptionMessage {
    INVALID_NAME_LENGTH_EXCEPTION_MESSAGE("자동차의 이름 길이는 1이상 5이하입니다."),
    INVALID_ATTEMPT_NUMBER_RANGE_EXCEPTION_MESSAGE("시도 횟수는 1이상입니다."),
    INVALID_NUMBER_EXCEPTION_MESSAGE("숫자만 입력 가능합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
