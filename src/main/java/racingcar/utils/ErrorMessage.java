package racingcar.utils;

public enum ErrorMessage {
    INVALID_CAR_NAME("자동차 이름은 5자 이하만 가능합니다."),
    INVALID_CAR_NAME_NULL("자동차 이름은 null 이 될 수 없습니다."),
    INVALID_CAR_NAME_EMPTY("자동차 이름은 공백이 될 수 없습니다."),
    CAN_NOT_FIND_MAX_POSITION("최대 위치를 찾을 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
