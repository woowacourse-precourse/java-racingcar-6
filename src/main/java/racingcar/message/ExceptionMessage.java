package racingcar.message;

public enum ExceptionMessage {
    LENGTH_LIMIT_EXCEEDED("자동차 이름은 5자 이하만 가능합니다."),
    DUPLICATE_NAME("중복된 이름을 입력할 수 없습니다.");

    final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
