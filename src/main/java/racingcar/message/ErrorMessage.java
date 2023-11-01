package racingcar.message;

public enum ErrorMessage {

    NOT_MORE_THAN_FIVE("자동차 이름은 5글자 이하여야 됩니다."),
    NO_SPACE_ALLOWED("자동차 이름에는 공백이 없어야 합니다."),
    NOT_EMPTY_ALLOWED("자동차 이름은 빈 문자열이 아니여야 합니다.");

    ErrorMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
