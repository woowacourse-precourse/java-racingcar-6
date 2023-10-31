package racingcar.constant;

public enum InputError {
    BLANK_CAR_NAME("자동차 이름은 비어있을 수 없습니다."),
    EXCEEDED_LIMIT_CAR_LENGTH("자동차 이름은 제한 길이를 초과할 수 없습니다."),
    NOT_DIGIT_MOVING_COUNT("이동 횟수는 숫자만 가능합니다."),
    EXCEEDED_MAXIMUM_INPUT("이동 횟수는 2147483647을 넘을 수 없습니다.");

    private final String message;

    InputError(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
