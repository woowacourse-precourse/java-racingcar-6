package racingcar.message;

public enum ErrorMessage {
    LAST_CHAR_COMMAS_ERROR("마지막 글자는 ,로 끝나면 안됩니다"),
    NAME_LENGTH_OVER_FOUR("이름이 4글자를 초과했습니다");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
