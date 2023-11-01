package racingcar.message;

public enum ErrorMessage {
    NOT_AN_INTEGER_OVER_ZERO("[ERROR] 0이상의 정수를 입력하여야 합니다."),
    CAR_NAME_LENGTH_MUST_BE_UNDER_5("[ERROR] 자동차 이름의 길이는 5 이하여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
