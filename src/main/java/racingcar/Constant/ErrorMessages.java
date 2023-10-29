package racingcar.Constant;

public enum ErrorMessages {
    NAME_INPUT_LENGTH_ERROR("이름은 5자 이하만 가능합니다."),
    NAME_INPUT_EMPTY_ERROR("이름은 공백이 될 수 없습니다.");

    private final String message;
    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
