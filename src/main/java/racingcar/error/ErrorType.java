package racingcar.error;

public enum ErrorType {

    INVALID_CAR_NAME_LENGTH("자동차 이름은 5글자 이하로만 가능합니다."),
    ;

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}