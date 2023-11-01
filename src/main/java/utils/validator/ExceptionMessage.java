package utils.validator;

public enum ExceptionMessage {
    NOT_INTEGER_ERROR(" : 시도할 횟수는 숫자로 입력해야 합니다."),
    EMPTY_INPUT_ERROR(" : 값을 입력해야 합니다."),
    DUPLICATE_CARNAME_ERROR(" : 서로 다른 자동차의 이름을 입력해야 합니다."),
    OUT_OF_LENGTH_CARNAME_ERROR(" : 유효한 글자수의 자동차 이름을 입력해야 합니다."),
    EMPTY_SPACE_INCLUDE_ERROR(" : 자동차 이름은 공백 없이 입력해야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
