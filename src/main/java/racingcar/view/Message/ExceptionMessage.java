package racingcar.view.Message;

public enum ExceptionMessage {
    INPUT_INTEGER_ROUND_ERROR_MESSAGE("시도할 횟수는 1이상이어야 합니다."),
    INPUT_STRING_ROUND_ERROR_MESSAGE("시도할 횟수는 숫자여야 합니다."),
    CAR_NAME_OVER_LENGTH_ERROR_MESSAGE("경주할 자동차 이름은 5자 이하만 가능합니다."),
    DUPLICATE_CAT_NAME_ERROR_MESSAGE("경주할 자동차 이름은 유일해야 합니다."),
    BLANK_OR_NULL_CAR_NAME_ERROR_MESSAGE("경주할 자동차 이름은 공백이 아니어야 합니다."),
    LESS_TWO_CAR_COUNT_ERROR_MESSAGE("경주할 자동차 수는 2대 이상이어야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
