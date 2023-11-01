package racingcar.constants;

public enum ErrorConsts {
    NULL_NAME("자동차 이름은 null이 될 수 없습니다."),
    BLANK_NAME("자동차 이름은 공백만으로는 구성할 수 없습니다."),
    LONG_NAME("자동차 이름은 %d자 이하만 가능합니다."),
    SMALL_COUNT("레이스 횟수는 %d 이상이어야 합니다.");

    private final String message;

    ErrorConsts(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(final int value) {
        return String.format(message, value);
    }
}
