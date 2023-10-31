package racingcar.util;

public enum ExceptionMessage {
    INVALID_CAR_NAME_LENGTH("이름은 5자 이하만 입력할 수 있습니다."),
    INVALID_CAR_COUNT("경주를 위해서 2개 이상의 이름을 입력해주세요."),
    INVALID_ATTEMPT_COUNT_RANGE("시도할 회수는 1 이상의 자연수만 입력할 수 있습니다."),
    INVALID_ATTEMPT_COUNT_FORMAT("시도할 회수는 숫자로만 입력할 수 있습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
