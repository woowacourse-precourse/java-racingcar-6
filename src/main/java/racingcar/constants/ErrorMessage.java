package racingcar.constants;

public enum ErrorMessage {

    CAR_NAME_ERROR_MESSAGE("자동차의 이름은 5자 이하만 가능합니다."),
    DUPLICATE_NAME_ERROR_MESSAGE("자동차의 이름은 중복될 수 없습니다."),
    NOT_DIGIT_ERROR_MESSAGE("시도할 횟수는 숫자만 입력 가능합니다."),
    NOT_CONTAINS_CAR_ERROR_MESSAGE("차량이 존재하지 않습니다."),
    PREFIX("[ERROR] ");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX.message + message;
    }
}
