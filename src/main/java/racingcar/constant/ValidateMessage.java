package racingcar.constant;

public enum ValidateMessage {
    CAR_NAME_MUST_NOT_BE_NULL_OR_EMPTY("자동차 이름은 null 이거나 빈 값이면 안됩니다."),
    CAR_NAME_INPUT_ERROR("유효하지 않은 자동차 이름 입니다. (',,' & ','는 처음 또는 마지막에 입력 불가!)"),
    CAR_NAME_MUST_BE_LOWER_THAN_FIVE("자동차 이름은 5자 이하이다."),
    CAR_NAME_CAN_NOT_BE_DUPLICATE("자동차 이름은 중복되면 안된다."),

    TRY_COUNT_MUST_NOT_BE_NULL_OR_EMPTY("시도할 횟수 입력값은 null 이거나 빈 값이면 안됩니다."),
    TRY_COUNT_MUST_BE_INTEGER("시도할 횟수 입력값은 숫자만 입력 가능합니다."),
    TRY_COUNT_MUST_BE_MORE_THAN_ONE("시도할 횟수 입력값은 1이상의 자연수만 입력 가능합니다.");

    private static final String errorMessage = "[ERROR] ";
    public final String message;

    ValidateMessage(String message) {
        this.message = message;
    }

    public void throwException() {
        throw new IllegalArgumentException(errorMessage + message);
    }
}
