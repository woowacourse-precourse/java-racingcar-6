package racingcar.util;

public enum Err {
    INVALID_CAR_NAME_MIN_LENGTH("자동차 이름은 1글자 이상 입력하셔야 합니다."),
    INVALID_CAR_NAME_MAX_LENGTH("자동차 이름은 5글자 이하로 입력하셔야 합니다.");

    private final String message;

    Err(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
