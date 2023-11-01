package racingcar.Util;

public enum ErrorMessage {
    ERROR_CAR_NAME_MAX_LENGTH("경주할 자동차 이름은 5자 이하만 가능합니다."),
    ERROR_CAR_NAME_MIN_LENGTH("경주할 자동차 이름은 1자 이상만 가능합니다."),
    ERROR_MOVEMENT_COUNT("시도할 회수는 1 이상의 정수만 가능합니다."),
    ERROR_EMPTY_PARTICIPATING_CAR("경주할 자동차 이름은 1개 이상이어야 합니다."),
    ERROR_FORMAT_MOVEMENT_COUNT("시도할 회수는 정수만 가능합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
