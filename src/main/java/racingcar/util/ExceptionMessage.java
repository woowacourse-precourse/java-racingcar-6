package racingcar.util;

public enum ExceptionMessage {
    NOT_POSITIVE_INTEGER("양의 정수만 입력 가능합니다."),
    INVALID_LENGTH("이름의 길이는 5자 이하로 제한됩니다."),
    DUPLICATED("입력값에 중복이 발생했습니다."),
    EMPTY_VALUE("입력값에 빈값이 발생했습니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
