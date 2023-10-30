package racingcar.message;

public enum OutputMessage {

    RESULT_MESSAGE("실행 결과"),
    SEPARATOR(" : "),
    WINNER("최종 우승자 : "),
    BAR("-"),
    LINE_BREAK(" ");


    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
