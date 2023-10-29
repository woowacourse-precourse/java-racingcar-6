package racingcar.constant;

public enum IllegalArgumentExceptionType implements ExceptionType<IllegalArgumentException> {
    CAR_NAME_MIN_LENGTH_ERROR_MESSAGE("차량 이름은 0보다 커야 합니다."),
    CAR_NAME_MAX_LENGTH_ERROR_MESSAGE("차량 이름의 길이는 5와 같거나 작아야 합니다."),
    EMPTY_CARS_ERROR_MESSAGE("차량은 한 대 이상이어야 합니다."),
    DUPLICATED_CARS_ERROR_MESSAGE("차량 이름이 중복되었습니다."),
    ATTEMPT_COUNT_INIT_ERROR_MESSAGE("최소 1회의 시도 횟수를 입력해 주세요."),
    READ_ATTEMPT_COUNT_ERROR_MESSAGE("숫자만 입력해 주세요");

    private final String message;

    IllegalArgumentExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(message);
    }
}
