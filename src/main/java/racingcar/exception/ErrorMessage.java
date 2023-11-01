package racingcar.exception;

public enum ErrorMessage {
    NULL_INPUT("입력 문자열이 비어있습니다. (Null)"),
    EMPTY_INPUT("입력 문자열이 비어있습니다. (Empty)"),
    NULL_NAME("이름이 존재하지 않습니다. (Null)"),
    EMPTY_NAME("이름이 존재하지 않습니다. (Empty)"),
    NAME_TOO_LONG("이름의 길이가 너무 깁니다."),
    DUPLICATED_NAME("이름이 중복되었습니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}