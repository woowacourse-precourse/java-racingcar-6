package racingcar.constant;

public enum ErrorMessage {

    INVALID_CAR_NAME_INPUT("자동차 이름 입력값이 잘못 사용되었습니다."),
    INVALID_CAR_NAME_LENGTH("자동차 이름의 길이가 잘못되었습니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String toValue() {
        return this.message;
    }
}
