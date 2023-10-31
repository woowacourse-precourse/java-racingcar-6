package racingcar.exception;

public enum InputException {

    INVALID_NAME_LENGTH("자동차 이름은 5자 이하만 가능합니다.");

    private final String exceptionMessage;

    InputException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
