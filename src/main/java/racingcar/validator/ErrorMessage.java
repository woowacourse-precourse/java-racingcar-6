package racingcar.validator;

public enum ErrorMessage {
    CAR_NAME_LENGTH_EXECESS("자동차의 이름은 5자 이하만 입력 가능합니다."),
    ONLY_NUMBER_POSSIBLE("숫자만 입력 가능합니다."),
    ;

    String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
