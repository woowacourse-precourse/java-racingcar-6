package racingcar.global;

public enum ErrorMessage {
    DUPLICATED_CAR_NAME("중복된 자동차 이름이 존재 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
