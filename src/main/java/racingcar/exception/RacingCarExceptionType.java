package racingcar.exception;

public enum RacingCarExceptionType {
    EMPTY_NAME("자동차 이름이 없습니다."),
    NAME_LENGTH_EXCEEDED("자동차 이름은 5자 이하만 가능합니다."),
    DUPLICATE_NAME("중복된 이름이 있습니다."),
    INVALID_CAR_NAME_FORMAT("잘못된 입력 형식입니다."),
    INVALID_TRY_COUNT_FORMAT("시도 횟수는 숫자만 입력 가능합니다."),
    NON_POSITIVE_TRY_COUNT("시도 횟수는 1 이상이어야 합니다."),
    EMPTY_CAR_LIST("레이싱 자동차 리스트가 비어 있습니다.");

    private final String message;

    RacingCarExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
