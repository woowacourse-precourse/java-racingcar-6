package racingcar.exception;

public enum ExceptionMessage {
    INVALID_INPUT_NOT_INTEGER_ERROR("Enter only Integer"),
    INVALID_CAR_NAME_LENGTH_ERROR("Car name should be less than 5 characters."),
    INVALID_CAR_INPUT_ERROR("You must enter at least one car name"),
    INVALID_DUPLICATE_NUMBER_ERROR("You must enter car name that is not duplicate");

    private final String errorMessage;

    ExceptionMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return errorMessage;
    }

}
