package racingcar.domain.util;

public enum ErrorMessage {

    CAR_NAME_LENGTH_OVER("자동차 이름의 길이가 6이상입니다."),
    ;

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
