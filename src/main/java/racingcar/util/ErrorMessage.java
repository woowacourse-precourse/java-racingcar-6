package racingcar.util;

public enum ErrorMessage {
    NAME_NULL_OR_EMPTY("자동차 이름이 누락되었습니다. 경주를 진행하려면 유효한 이름을 입력해주세요."),
    NAME_MAX_LENGTH("자동차_이름은 최대 5자 이하만 가능합니다."),
    NAME_NO_WHITESPACE("자동차 이름에서 공백은 허용하지 않습니다."),
    NAME_IS_NOT_UNIQUE("중복된 자동차 이름이 존재합니다."),
    INVALID_INPUT_NUMBER("숫자를 입력하세요."),
    INVALID_INPUT_TOO_LOW("입력된 숫자는 1보다 커야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
