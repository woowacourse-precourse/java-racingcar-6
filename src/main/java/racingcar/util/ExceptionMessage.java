package racingcar.util;

public enum ExceptionMessage {
    CHECK_NUMBERS_LENGTH("이름은 5자 이내로 입력해주세요.");

    public static final String ERROR = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(ERROR, message);
    }

    public String getMessage() {
        return message;
    }
}
