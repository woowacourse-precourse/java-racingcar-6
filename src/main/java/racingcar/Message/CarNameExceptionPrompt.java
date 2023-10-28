package racingcar.Message;

public enum CarNameExceptionPrompt {

    LENGTHMESSAGE("자동차 이름은 1글자 이상 5자 이하만 가능합니다.\n"),
    WHITESPACEMESSAGE("자동차 이름에 공백이 포함되어 있습니다.\n"),
    DUPLICATEMESSAGE("자동차 이름이 중복되었습니다.\n");

    private String message;

    CarNameExceptionPrompt(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
