package racingcar.message;

public enum ErrorMessage {
    CAR_NAME_IS_BIGGER_THAN_5CHAR("[ERROR] 자동차 이름은 5자 이하만 가능합니다."),
    MOVE_COUNT_IS_NOT_NUM("[ERROR] 시도 횟수는 숫자여야 합니다."),
    MOVE_COUNT_IS_NOT_POSITIVE_NUM("[ERROR] 시도 횟수는 1 이상이어야 합니다."),
    CAR_NAME_HAVE_WHITE_CHAR("[ERROR] 자동차 이름에 공백이 있을 수 없습니다."),
    CAR_NAME_IS_DUPLICATED("[ERROR] 자동차 이름이 중복되면 안됩니다."),
    CAR_NAME_IS_EMPTY("[ERROR] 자동차 이름이 비어 있을 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
