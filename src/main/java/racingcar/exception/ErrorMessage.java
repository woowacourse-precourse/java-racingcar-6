package racingcar.exception;

public enum ErrorMessage {
    NOT_INTEGER("[ERROR] 숫자만 입력가능합니다."),
    INVALID_NAME_LENGTH("[ERROR] 잘못된 이름 길이입니다."),
    CANT_FIND_MAX_VALUE("[ERROR] 최대 위치를 찾을 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
