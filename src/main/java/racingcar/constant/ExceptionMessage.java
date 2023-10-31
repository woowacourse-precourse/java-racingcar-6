package racingcar.constant;

public enum ExceptionMessage {
    LENGTH_EXCEED("길이를 초과하였습니다."), INVALID_VALUE("올바르지 않은 값을 입력하였습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
