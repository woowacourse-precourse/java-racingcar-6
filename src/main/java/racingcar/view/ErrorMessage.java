package racingcar.view;

public enum ErrorMessage {
    WRONG_CAR_NAME_ERROR_MESSAGE("차량 이름은 5글자 이하이어야 합니다."),
    NOT_A_INTEGER_NUMBER_ERROR_MESSAGE("숫자만 입력 가능합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
