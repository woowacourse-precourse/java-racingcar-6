package racingcar.constant;

public enum ExceptionMessage {
    NULL_INPUT_ERROR_MESSAGE("null 값을 입력할 수 없습니다."),
    EMPTY_INPUT_ERROR_MESSAGE("값을 입력해주세요."),
    CAR_NAME_LENGTH_ERROR_MESSAGE("자동차 이름은 5자 이하만 가능합니다."),
    DUPLICATE_CAR_NAME_ERROR_MESSAGE("중복되는 자동차 이름은 입력 될 수 없습니다."),
    NOT_INTEGER_VALUE_ERROR_MESSAGE("시도할 회수는 숫자로만 입력 가능합니다."),
    DISABLE_INPUT_ERROR_MESSAGE("시도할 회수는 1이상의 숫자여야 합니다.");

    public final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public void throwException() {
        throw new IllegalArgumentException(exceptionMessage);
    }
}
