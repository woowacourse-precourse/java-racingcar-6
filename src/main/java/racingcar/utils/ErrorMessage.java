package racingcar.utils;

public enum ErrorMessage {
    OUT_OF_MEMORY_OF_NAMES(0, "Input car names is too large in this system!"),
    OUT_OF_MEMORY_OF_TRIES(1, "Tries Input is too large at this system!"),
    NAMES_INPUT_IS_BLANK(2, "Input car names are not exist!"),
    NEXT_NAMES_NOT_ENTERED(3, "Input car names are not exist!"),
    ENTERED_CAR_IS_BLANK(4, "Car name is not entered!"),
    ENTERED_CAR_IS_TOO_LONG(5, "Car name is longer!"),
    TRIES_INPUT_IS_TOO_LONG(6, "Tries Input is too long!"),
    TRIES_IS_NEGATIVE(7, "Tries Input is not negative!"),
    TRIES_IS_NOT_INT(8, "Tries Input is not a Integer number!");

    int code;
    String errorMessage;

    ErrorMessage(int code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

