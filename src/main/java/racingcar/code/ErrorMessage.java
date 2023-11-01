package racingcar.code;

public enum ErrorMessage {
    NOT_EMPTY("빈 값을 입력 할 수 없습니다."),
    INVALID_NAME("자동차 이름을 제대로 입력해 주세요."),
    MAX_CAR_NAME_SIZE_EXCEEDED("자동차 이름은 빈값이거나 최대 사이즈를 초과할 수 초과 할 수 없습니다. size : "),
    ONLY_NUMBER("숫자만 입력 가능합니다."),
    ONE_OVER_NUMBER("1 이상의 숫자만 입력 가능합니다."),
    ;

    private String description;

    ErrorMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
