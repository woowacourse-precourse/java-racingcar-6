package racingcar.config;

public enum GameMessages {
    ;


    private final String message;
    GameMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
