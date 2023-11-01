package racingcar.constant;

public enum ErrorMessage {
    NON_NUMERIC_VALUE("숫자 이외의 값은 입력할 수 없습니다."),
    EMPTY_VALUE("공백은 입력할 수 없습니다."),
    OUT_OF_STANDARD("자동차 이름은 5자 까지만 입력할 수 있습니다."),
    DUPLICATED_VALUES("서로 중복되는 이름은 입력할 수 없습니다."),
    SINGLE_COUNT("2개 이상의 이름을 입력해주세요."),
    NEGATIVE_VALUE("0보다 큰 숫자만 입력할 수 있습니다.");

    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
