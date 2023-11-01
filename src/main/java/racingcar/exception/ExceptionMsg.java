package racingcar.exception;

public enum ExceptionMsg {
    INVALID_LENGTH_NAME("5자 이하의 이름을 입력해 주세요."),
    INVALID_DUPLICATE_NAME("중복된 이름이 존재합니다."),
    INVALID_BLANK("공백은 입력할 수 없습니다."),
    INVALID_INPUT_NUMBER("숫자를 입력해 주세요."),
    INVALID_INPUT_NUMBER_RANGE("범위에 맞는 숫자를 입력해 주세요.");

    private final String message;

    ExceptionMsg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
