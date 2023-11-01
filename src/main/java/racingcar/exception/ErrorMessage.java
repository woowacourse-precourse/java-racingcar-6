package racingcar.exception;

public enum ErrorMessage {
    EMPTY("The input cannot be empty"),
    ENDS_WITH_DELIMITER("The input cannot ends with a delimiter."),
    ENDS_WITH_NEW_LINE("The input cannot ends with a new line."),
    CONTAIN_IMPROPER_LETTER("The input cannot contain an improper letter."),
    TOO_LONG_NAME("The name length cannot be longer than a length configured by the game."),
    INVALID_ROUND_COUNT("The round count cannot be smaller than configured by the game setting."),
    DUPLICATED("The input cannot contain a duplication."),
    SYSTEM_ERROR("The game system crashed.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

