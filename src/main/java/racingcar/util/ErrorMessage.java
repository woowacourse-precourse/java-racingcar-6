package racingcar.util;

public enum ErrorMessage {
    NAME_LENGTH("자동차_이름은 1자 이상 5자 이하이어야 합니다."),
    NAME_NO_WHITESPACE("자동차 이름에서 공백은 허용하지 않습니다."),
    NAME_IS_NOT_UNIQUE("이미 등록된 자동차 이름입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
