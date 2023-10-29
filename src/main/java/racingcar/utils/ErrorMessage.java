package racingcar.utils;

public enum ErrorMessage {
    INVALID_SPLIT_CHAR("구분자로 쉼표(,)를 사용해야 합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
