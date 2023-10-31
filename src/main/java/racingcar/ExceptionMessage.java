package racingcar;

public enum ExceptionMessage {
    OUT_OF_CAR_NAME_LENGTH("자동차의 이름은 6글자를 넘길 수 없습니다."),
    BLANK_CAR_NAME("자동차의 이름이 공백이 될 수 없습니다."),
    DUPLICATE_CAR_NAME("자동차의 이름이 중복됩니다."),

    private final static String EXCEPTION_HEADER = "[error] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return EXCEPTION_HEADER + message;
    }
}
