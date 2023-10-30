package racingcar.view;

public enum ErrorMessage {
    CAR_NAME_LENGTH_ERROR_MESSAGE("car name length must be smaller than 6."),
    NUMBER_OF_TRY_TYPE_ERROR_MESSAGE("number of try must be typed number."),
    NUMBER_OF_TRY_RANGE_ERROR_MESSAGE("number range of try must be bigger than 0.");

    private String errorMessage;

    ErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
