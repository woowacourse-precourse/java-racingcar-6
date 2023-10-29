package racingcar.exception;

public enum IllegalArgumentMessage {
    NOT_NULL("null이 아니어야 합니다."),
    UNDER_5_LENGTH_OR_NON_EMPTY("자동차 이름은 5자 이내이거나 공백이 아니어야 합니다.");

    private String message;

    IllegalArgumentMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}