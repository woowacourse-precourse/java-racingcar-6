package racingcar.constant;

public enum CarNamesExceptionMessage {
    EMPTY_INPUT("입력은 비어 있을 수 없습니다."),
    INVALID_CAR_NAME_LENGTH("구분된 각 자동차 이름의 길이가 제한 길이를 초과합니다."),
    EMPTY_CAR_NAME("자동차 이름의 길이는 0이 될 수 없습니다.");

    private final String message;

    CarNamesExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
