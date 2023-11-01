package racingcar.variables;

public enum ErrorMessages {
    CAR_NAME_ERROR("차의 이름은 5자 이하만 가능합니다.");

    private ErrorMessages(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    private String ErrorMessage;

    public String getErrorMessage() {
        return ErrorMessage;
    }
}
