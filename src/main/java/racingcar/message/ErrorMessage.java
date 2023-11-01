package racingcar.message;

public enum ErrorMessage {

    EXCEED_NAME_LENGTH("이름은 5자 이하만 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
