package racingcar.constant;

public enum ExceptionMessage {

    NOT_INTEGER("숫자만 입력할 수 있습니다."),
    INCORRECT_DELIMITER("이름을 ','로만 구분해 주십시오."),
    TOO_LONG_NAME_LENGTH("이름은 5글자 이하로만 입력할 수 있습니다."),
    DUPLICATE_NAME("중복되는 이름은 입력할 수 없습니다.");
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
