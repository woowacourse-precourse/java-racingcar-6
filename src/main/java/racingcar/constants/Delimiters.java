package racingcar.constants;

public enum Delimiters {

    CAR_NAME_DELIMITER(","),
    RACE_WINNER_DELIMITER(", "),
    CAR_NAME_DELIMITER_DESCRIPTION("쉼표(,)");

    private final String message;

    Delimiters(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}