package racingcar.message;

public enum ErrorMessages {
    INVALID_CAR_NAME("자동차 이름은 5자 이하만 가능합니다."),
    INVALID_CAR_NAME_LENGTH("자동차 이름은 1자 이상만 가능합니다."),
    INVALID_CAR_NAME_BLANK("자동차 이름은 공백을 입력할 수 없습니다."),
    INVALID_NUMERIC_INPUT("숫자만 입력 가능합니다.")
    ;
    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
