package racingcar.model.exception;

public enum ExceptionMessage {

    DUPLICATE_CAR_EXCEPTION("같은 이름을 가진 자동차가 있으면 안 됩니다.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
