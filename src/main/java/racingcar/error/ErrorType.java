package racingcar.error;

public enum ErrorType {

    INVALID_CAR_NAME_LENGTH("자동차 이름은 5글자 이하로만 가능합니다."),
    INVALID_ATTEMPT_COUNT_INPUT("잘못된 시도 회수 입력입니다. 양의 정수만 입력 가능합니다."),
    ;

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}