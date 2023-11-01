package racingcar.domain;

public enum StringConstant {

    TRIAL_NUMBER_RANGE("^[0-9]*$"),
    NONE_TRY("0"),
    MULTI_WINNER_DELIMITER(", "),
    CAR_NAME_SPLIT_DELIMITER(",");

    private final String message;

    StringConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
