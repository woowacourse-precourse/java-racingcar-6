package validation;

public enum ErrorMessage {
    NAME_LENGTH_ERROR("자동차 이름은 1이상 5이하만 가능합니다."),
    NAME_DUPLICATE_ERROR("자동차 이름은 중복될 수 없습니다."),
    ROUND_INPUT_ERROR("정수를 입력해 주세요"),
    ROUND_LENGTH_ERROR("라운드는 1이상 20이하만 가능합니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
