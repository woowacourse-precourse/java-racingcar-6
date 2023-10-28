package racingcar.domain.validator.exception;

public enum CarNameException {
    NO_VALUE_NAME("자동차 이름을 위한 입력값이 입력되지 않았습니다."),
    INVALID_TOO_LONG_NAME("자동차 이름은 최대 10자 이하로 가능합니다."),
    INVALID_TOO_SHORT_NAME("자동차 이름은 최소 2자 이상으로 가능합니다.");

    private final String message;

    CarNameException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}