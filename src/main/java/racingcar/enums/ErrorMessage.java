package racingcar.enums;

public enum ErrorMessage {
    ONLY_NUMBER("시도할 횟수는 숫자만 가능합니다."),
    UNDER_FIVE("자동차 이름은 5자 이하만 가능합니다."),
    LIST_EMPTY("차가 없습니다.");

    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
