package racingcar.constant;

public enum ErrorMessages {
    NAME_INPUT_LENGTH_ERROR("이름은 5자 이하만 가능합니다."),
    NAME_INPUT_EMPTY_ERROR("이름은 공백이 될 수 없습니다."),
    REPEAT_NUMBER_INPUT_ERROR("시도 횟수는 숫자만 가능합니다."),

    REPEAT_NUMBER_MINUS_ERROR("시도 횟수는 0보다 커야합니다.");

    private final String message;
    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
