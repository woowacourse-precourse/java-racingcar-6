package racingcar.exception;

public enum RacingCarExceptionMessage {
    NOT_AVAILABLE_CAR_NAME_LENGTH_RANGE("자동차 이름은 최소 1자 이상 최대 5자 이하만 가능합니다."),
    NOT_AVAILABLE_CAR_NAME_CHARACTER("자동차 이름은 한글, 영어, 숫자만 가능합니다."),
    NOT_AVAILABLE_CAR_LIST("올바르지 않은 자동차 리스트입니다."),
    DUPLICATED_CAR_NAMES("각 자동차의 이름은 고유해야 합니다."),
    ATTEMPT_COUNTS_NOT_IN_RANGE("시도 횟수는 1 이상 2억 이하의 숫자만 입력 가능합니다."),
    ATTEMPT_COUNTS_NOT_NUMBER("입력값이 숫자가 아닙니다."),
    ;


    private final String message;

    RacingCarExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
