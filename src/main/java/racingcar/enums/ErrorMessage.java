package racingcar.enums;

public enum ErrorMessage {
    LENGTH_OF_NAME_RANGE("자동차 이름의 길이는 1 이상 5 이하 입니다."),
    NUMBER_OF_ATTEMPTS_RANGE("시도 횟수는 0 이상의 정수입니다."),
    ATTEMPS_STRING_TO_INTEGER("문자가 포함된 문자열은 정수로 변환할 수 없습니다.");

    private final String message;

    ErrorMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
