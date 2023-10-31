package racingcar.error;

public enum ErrorMessage {
    LONG_CAR_NAME("자동차 이름이 5글자를 초과합니다."),
    NO_REGISTERED_CAR("경주에 참여한 자동차가 하나도 없습니다."),

    INVALID_LOOP_COUNT("부적절한 시도 횟수입니다."),
    NEGATIVE_LOOP_COUNT("시도 횟수는 양수여야 합니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
