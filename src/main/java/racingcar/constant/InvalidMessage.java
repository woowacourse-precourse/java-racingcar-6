package racingcar.constant;

public enum InvalidMessage {
    DUPLICATE_NAME("이름이 중복되었습니다."),
    NAME_LENGTH("1 ~ 5자리의 이름을 입력하세요."),
    ALPHABETIC_NAME("알파벳을 입력하세요.");

    private final String message;

    InvalidMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
