package racingcar.constants;

public enum ErrorMessage {
    ERROR_NAME_MUST_BE_5_CHARACTERS_LESS("자동차 이름은 5자 이하만 가능합니다."),
    ERROR_NAME_MUST_BE_NUMBER("숫자를 입력해주세요."),
    ERROR_NAME_MUST_BE_NOT_DUPLICATED("자동차 이름이 중복되었습니다."),
    ERROR_NAME_MUST_NO_SPACE("자동차 이름은 공백이 될 수 없습니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
