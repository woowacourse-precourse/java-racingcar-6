package racingcar.constant;

public enum ErrorMessage {
    INVALID_CAR_NAME("자동차의 이름이 잘못되었습니다."),
    INVALID_TRY_COUNT("시도 횟수가 잘못되었습니다."),
    INVALID_RACING_STATUS("레이스의 상태가 잘못되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
