package racingcar.error;

public enum ErrorMessage {
    INPUT_UNDER_ONE_EXCEPTION("0 이하의 수가 입력되었습니다."),
    INVALID_NUMBER_FORMAT_EXCEPTION("올바른 숫자 입력 형식이 맞지 않습니다."),
    NAME_LENGTH_EXCEEDED_EXCEPTION("입력한 이름이 5글자 이상 입니다."),
    ;
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}