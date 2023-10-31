package racingcar.constant;

public enum MessageConstant {
    CAR_NAME_INPUT_COUNT_ERROR("1대 이상의 자동차를 입력해주세요."),
    CAR_NAME_INPUT_DUPLICATE_ERROR("서로 다른 자동차 이름을 입력해주세요."),

    CAR_NAME_LENGTH_ERROR("자동차의 이름은 1자 이상 5자 이하야야합니다."),
    CAR_NAME_CONTAINS_SPACE_ERROR("자동차의 이름은 공백이 포함되지 말아야합니다."),

    TOTAL_ROUND_INPUT_ERROR("1 이상의 양의 정수를 입력해야합니다."),

    CAR_NAME_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");

    private final String message;

    MessageConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
