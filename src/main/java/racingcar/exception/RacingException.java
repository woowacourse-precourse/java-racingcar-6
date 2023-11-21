package racingcar.exception;

public enum RacingException {
    INVALID_CARS_NAME("잘못된 이름입니다."),
    INVALID_NUMBERS("잘못된 값입니다."),
    INVALID_INPUT_FORMAT("입력 형식이 잘못되었습니다."),

    NOT_NUMBER("숫자를 입력해 주세요."),
    NO_CAR_FOUNDED("자동차를 입력해 주세요."),
    DUPLICATE_CARS_NAME("자동차의 이름이 중복됩니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    RacingException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }

    public IllegalArgumentException makeException() {
        return new IllegalArgumentException(getMessage());
    }
}
