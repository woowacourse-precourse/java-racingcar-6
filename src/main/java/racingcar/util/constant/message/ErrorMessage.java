package racingcar.util.constant.message;

public enum ErrorMessage {
    NOT_A_NUMBER("[ERROR] 숫자가 아닙니다."),
    TOO_LONG("[ERROR] 5자리 이하의 이름만 사용가능 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}