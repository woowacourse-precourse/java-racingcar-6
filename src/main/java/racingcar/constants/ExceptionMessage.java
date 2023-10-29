package racingcar.constants;

public enum ExceptionMessage {
    EMPTYNAME("비어있는 이름이 들어왔습니다."),
    EXPLODENAME("이름이 5자를 초과했습니다."),
    NOTINTEGER("정수를 입력해야합니다."),
    DUPLICATEDNAME("중복된 이름이 존재합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
