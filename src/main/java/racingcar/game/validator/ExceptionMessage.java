package racingcar.game.validator;

public enum ExceptionMessage {
    LESS_THEN_FIVE_LETTERS("자동차 이름은 5자 이하만 가능합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
