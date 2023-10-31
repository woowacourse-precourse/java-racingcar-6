package racingcar.exception;

public enum IllegalArgumentMessage {
    NOT_NULL("시도 횟수와 자동차 이름은 null이 아니어야 합니다."),
    ONLY_POSITIVE("시도 횟수는 양수여야 합니다."),
    ONLY_DIGIT("시도 횟수는 숫자여야 합니다."),
    UNDER_5_LENGTH_OR_NON_EMPTY("자동차 이름은 5자 이내이거나 공백이 아니어야 합니다.");

    private String message;

    IllegalArgumentMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}