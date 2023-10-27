package racingcar;

public enum ExceptionMessage {

    CAR_NAME_LENGTH_EXCEPTION("자동차 이름 길이가 초과되었습니다."),
    CAR_NAME_DUPLICATE_EXCEPTION("중복된 이름이 있으면 안 됩니다."),
    CAR_NAME_BLANK_EXCEPTION("공백이 있으면 안 됩니다."),
    CAR_NAMV_VALUE_EXCEPTION("자동차 이름은 숫자, 알파벳, 한글만 가능합니다."),
    PLAY_COUNT_VALUE_EXCEPTION("횟수 값이 올바르지 않습니다.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
