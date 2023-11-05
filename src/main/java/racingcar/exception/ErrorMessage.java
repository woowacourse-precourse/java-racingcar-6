package racingcar.exception;

public enum ErrorMessage {

    VALIDATE_EMPTY_FOR_INPUT_STRING("입력값은 비어있지 않아야 합니다."),
    VALIDATE_CONTAINS_COMMA_FOR_INPUT_STRING("입력값은 쉼표(,)를 기준으로 구분되어야 합니다."),
    VALIDATE_DIGIT_FOR_INPUT_STRING("입력값은 정수이어야 합니다."),
    VALIDATE_SIGN_FOR_INPUT_STRING("입력값은 양의 정수이어야 합니다."),
    VALIDATE_DUPLICATE_FOR_LIST("각각의 이름은 중복될 수 없습니다."),
    VALIDATE_EMPTY_FOR_EACH_NAME("이름은 비어있지 않아야 합니다."),
    VALIDATE_LENGTH_FOR_EACH_NAME("이름의 길이는 %s 이하이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
