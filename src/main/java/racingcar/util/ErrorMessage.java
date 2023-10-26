package racingcar.util;

public enum ErrorMessage {

    NUMBER_FORMAT_ERROR(""),
    BLANK_ERROR("공백은 입력 불가능 합니다."),
    LENGTH_ERROR("5자 이하의 이름만 가능합니다."),
    ONLY_NUMERIC_ERROR("숫자만 입력 가능합니다."),
    NO_NUMERIC_ERROR("숫자는 입력 불가능 합니다."),
    NEGATIVE_NUMBER_ERROR("자연수만 입력 가능합니다."),
    INVALID_NUMBER_ERROR("유효하지 않은 입력입니다."),
    SPLIT_REGEX_ERROR("쉼표(,)로만 구분 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
