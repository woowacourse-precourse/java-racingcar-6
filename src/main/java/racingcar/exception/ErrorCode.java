package racingcar.exception;

public enum ErrorCode {
    INVALID_NAME_LENGTH("자동차 이름은 5자 이하여야 합니다."),
    DUPLICATE_NAME("자동차 이름은 중복될 수 없습니다."),
    EMPTY_NAME("자동차 이름은 앞뒤 공백을 제외한 1자 이상으로 입력해야 합니다."),
    EMPTY_NAME_LIST("자동차 이름을 하나 이상 입력해야 합니다."),
    NON_INT_TRY_COUNT("시도할 횟수는 정수로 입력해야 합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
