package racingcar.message;

public enum ErrorMessage {
    INVALID_CAR_NAME("차의 이름은 5자 이하만 가능"),
    DUPLICATED_CAR_NAME("중복되지 않은 이름만 가능"),
    INVALID_TIMES("레이스 진행 횟수는 자연수만 가능");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
