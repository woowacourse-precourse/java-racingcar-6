package racingcar.common.exception;

public enum ErrorMessage {
    BLANK_INPUT("공백이 아닌 문자를 입력해주세요."),
    INVALID_NUMERIC_INPUT("숫자로만 입력해주세요."),
    INVALID_LENGTH_INPUT("유효하지 않은 입력 길이입니다. 다시 입력해주세요."),
    INVALID_RACING_CAR_NAME_LENGTH("이름은 공백이 아니어야 하며, 5글자 이하여야 합니다."),
    INVALID_RACING_CAR_NAME_FORMAT("이름은 알파벳이나 숫자로만 이루어져야 합니다."),
    INVALID_NUMBER_OF_RACING_CAR("등록할 수 있는 자동차는 100개 이하입니다."),
    DUPLICATED_RACING_CAR_NAME("자동차 이름은 서로 중복되지 않아야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public RacingCarException getException() {
        return new RacingCarException(this.message);
    }
}
