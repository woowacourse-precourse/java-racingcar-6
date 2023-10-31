package racingcar;

public enum ErrorMessage {
    CAR_NAME_LENGTH_EXCEPTION("자동차 이름은 5글자 이하입니다."),
    IS_NOT_NUMBER("숫자만 입력 가능합니다."),
    DUPLICATE_CAR_NAME("중복된 자동차 이름 입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
