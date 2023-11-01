package racingcar.enums;

public enum GlobalMessage {

    NEW_LINE(System.lineSeparator()),
    BLANK_AND_NEW_LINE(System.lineSeparator().repeat(2)),
    ;

    private final String message;

    GlobalMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

}
