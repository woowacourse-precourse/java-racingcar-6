package racingcar.constant;

public enum ErrorMessage {
    CAR_NAME_INPUT_EXCEPTION("잘못된 입력입니다. 쉼표를 기준으로 자동차 이름을 입력해주세요."),
    CAR_NAME_LENGTH_EXCEPTION("각 자동차 이름은 5자 이하로 입력해주세요."),
    DUPLICATE_CAR_NAME_EXCEPTION("중복된 자동차 이름은 허용하지 않습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
