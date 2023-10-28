package util;

public enum CarNameErrorMessage {
    SPACE_IN_NAME("이름에 스페이스가 포함되어있습니다."),
    NAME_LENGTH("이름이 5글자를 초과했습니다.");

    private final String message;

    CarNameErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
