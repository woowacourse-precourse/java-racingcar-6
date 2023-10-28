package racingcar.enums;

public enum ErrorMessage {
    LENGTH_OF_NAME_RANGE("자동차 이름의 길이는 1 이상 5 이하 입니다."),
    NUMBER_OF_ATTEMPTS_RANGE("시도 횟수는 0 이상의 정수입니다.");

    private String message;

    ErrorMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
