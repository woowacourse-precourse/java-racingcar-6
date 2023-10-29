package racingcar.domain.util;

public enum ErrorMessage {

    CAR_NAME_LENGTH_OVER("자동차 이름의 길이가 6이상입니다."),
    TRY_COUNT_IS_NOT_DIGIT("입력한 시도 횟수가 숫자가 아닙니다."),
    ;

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
