package racingcar.type;

public enum ErrorCode {
    TURN_IS_MORE_THAN_ZERO("0보다 큰 회수를 입력해주세요."),
    CAR_NAME_IS_NOT_DUPLICATE_AND_LESS_THAN_5("중복되지 않는 5자 이하의 자동차 이름을 입력해주세요.");

    private String message;

    private ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
