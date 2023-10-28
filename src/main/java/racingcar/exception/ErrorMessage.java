package racingcar.exception;

public enum ErrorMessage {
    EMPTY("The input cannot be null"),
    CONTAIN_TAB("The input cannot ends with tab"),
    ENDS_WITH_DELIMITER("The input cannot ends with delimiter"),
    ENDS_WITH_NEW_LINE("The input cannot ends with new line"),
    CONTAIN_IMPROPER_LETTER("The input cannot contain improper letters."),
    TOO_LONG_INPUT("The input length cannot be over from length configured by the game."),
    SYSTEM_ERROR("The game system has crashed");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

