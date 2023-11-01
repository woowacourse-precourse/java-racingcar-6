package enums;

public enum ErrorMessages {

    MAX_LENGTH_ERROR("문자열의 길이는 5이하 이여야 합니다."),
    INVALID_INTEGER_INPUT_MESSAGE("잘못된 입력입니다. 유효한 정수를 입력해주세요.");
    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
