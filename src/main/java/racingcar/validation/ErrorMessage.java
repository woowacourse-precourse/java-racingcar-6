package racingcar.validation;

public enum ErrorMessage {
    LENGTH_OVER("사용자 이름 입력길이 초과"),
    NOT_NUMBER("숫자가 아닙니다."),
    DUPLICATED_NAME("중복된 이름입니다."),
    EMPTY_NAME("공백은 이름이 될 수 없습니다."),
    NOT_POSITIVE_NUMBER("양수가 아닙니다. ");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
