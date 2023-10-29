package racingcar.exception;

public enum InputErrorCode {
    INVALID_CAR_NAME_SIZE("자동차 이름은 5글자 초과할 수 없습니다."),
    BLANK_INPUT("빈값은 입력이 불가능합니다."),
    NOT_INTEGER_INPUT("시도 횟수는 숫자만 가능합니다."),
    NEGATIVE_INTEGER_INPUT("시도 횟수는 양수만 가능합니다.");

    private final String message;

    InputErrorCode(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
