package racingcar.error;

public enum ErrorCode {
    EXCEED_NAME_LENGTH("이름 길이를 초과했습니다."),
    INVALID_TRY_COUNT("시도 횟수에 문자가 들어왔습니다");

    private String message;
    private ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
