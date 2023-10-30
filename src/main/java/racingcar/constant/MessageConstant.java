package racingcar.constant;

public enum MessageConstant {
    CAR_NAME_INPUT_COUNT_ERROR("1대 이상의 자동차를 입력해주세요."),
    CAR_NAME_INPUT_DUPLICATE_ERROR("서로 다른 자동차 이름을 입력해주세요.");

    private final String message;

    MessageConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
