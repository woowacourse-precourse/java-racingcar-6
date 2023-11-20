package racingcar.message;

public enum ErrorMessage {
    CAR_NAME_ERROR("[ERROR] 잘못된 이름입니다."),
    INCLUDE_NULL_ERROR("[ERROR] 입력에 공백이 있습니다."),
    NOT_NUMBERS_ERROR("[ERROR] 잘못된 숫자입니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
