package racingcar.constant;

public enum ErrorMessage {

    CAR_NAME_LENGTH_EXCEPTION("Please enter each car name within 5 characters or less."),
    DUPLICATE_CAR_NAME_EXCEPTION("Duplicate car names are not allowed."),
    MOVEMENT_TIME_INPUT_EXCEPTION("Invalid input. Please enter the number of attempts for movement."),
    MOVEMENT_TIME_TYPE_EXCEPTION("Please enter the number of attempts for movement as a numeric value.");

    private String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
