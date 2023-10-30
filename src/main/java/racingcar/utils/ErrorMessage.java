package racingcar.utils;

public enum ErrorMessage {
    EMPTY_NAME_ERROR("자동차의 이름은" + Constraints.MIN_SIZE.getValue() + "보다 커야 합니다."),
    OVER_THRESHOLD_ERROR("자동차의 이름은" + Constraints.MAX_SIZE.getValue() + "보다 작아야 합니다."),
    NAME_DUPLICATE_ERROR("중복된 자동차 이름이 존재 합니다.");

    private final String message;

    ErrorMessage(String value) {
        this.message = value;
    }

    public String getMessage() {
        return message;
    }
}
