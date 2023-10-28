package racingcar.constants;

public enum ExceptionMessage {
    NONE_INPUT_CARS("자동차 이름은 공백이 될 수 없습니다."),
    CAR_NAME_LIMIT_EXCEEDED("자동차 이름은 5자 이하만 가능합니다."),
    NOT_INPUT_CARS_DUPLICATE("자동차 이름은 중복될 수 없습니다."),
    CARS_LESS_THAN_TWO("자동차 이름은 2개 이상이어야 합니다."),
    INVALID_CHARACTER_INPUT_ERROR("문자,쉼표만 입력 가능 합니다."),
    INVALID_INPUT_ERROR_MESSAGE("유효하지 않은 입력입니다. 0보다 큰 숫자만 입력 가능합니다.");
    private static final String ERROR_TAG = "[ERROR] ";
    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = ERROR_TAG + exceptionMessage;
    }

    public void throwException() {
        throw new IllegalArgumentException(exceptionMessage);
    }
}
