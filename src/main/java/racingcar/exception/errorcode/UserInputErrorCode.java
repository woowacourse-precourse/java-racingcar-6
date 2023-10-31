package racingcar.exception.errorcode;

public enum UserInputErrorCode {
    INPUT_VALUE_BLANK("입력값은 공백일 수 없습니다."),
    INPUT_VALUE_NOT_NUMERIC("입력값은 숫자여야 합니다."),
    DUPLICATED_CAR_NAME("자동차 이름은 중복일 수 없습니다."),
    INVALID_CAR_NAME_LENGTH("자동차 이름은 최대 5자까지 가능합니다."),
    INVALID_TOTAL_ROUND_RANGE("라운드는 최소 1회 이상이여야 합니다.");

    private final String message;

    UserInputErrorCode(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
