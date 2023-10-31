package racingcar.enums;

public enum OutputMessage {
    NEW_LINE(System.lineSeparator()),
    WINNER_MESSAGE("최종 우승자 : "),
    RESULT_MESSAGE(NEW_LINE.getMessage() + "실행 결과"),
    JOIN_DELIMITER(", "),
    COLON(" : "),
    DASH("-");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
