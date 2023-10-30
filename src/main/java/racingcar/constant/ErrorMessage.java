package racingcar.constant;

public enum ErrorMessage {
    EMPTY_INPUT_ERROR("입력값이 비어있습니다."),
    LENGTH_INPUT_ERROR("자동차의 이름이 %d자 이하여야 합니다."),
    DUPLICATE_INPUT_ERROR("자동차의 이름이 중복되는 경우가 존재합니다."),
    NUMERIC_INPUT_ERROR("숫자로만 입력되어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
