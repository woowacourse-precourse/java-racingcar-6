package racingcar.message;

public enum ErrorMessage {
    LENGTH_LIMIT("제한 길이를 초과하였습니다."),
    INPUT_NULL("입력값이 없습니다."),
    INPUT_BLANK("입력값이 공백입니다."),
    IS_NOT_NUMBER("입력값이 유효한 숫자가 아닙니다."),
    DUPLICATE_NAME("중복된 이름입니다."),
    EMPTY_CAR_LIST("자동차 목록이 비어 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
