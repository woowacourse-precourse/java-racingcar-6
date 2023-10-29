package message;

public enum ErrorMessage {
    TOO_LONG_NAME_LENGTH_ERROR_MESSAGE("자동차 이름은 5자 이하로 입력해야 됩니다."),
    DUPLICATE_NAME_ERROR("중복된 자동차 이름이 입력되었습니다.");

    String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
