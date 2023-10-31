package racingcar.view;

public enum OutputMessages {

    EXECUTE_RESULT("\n실행 결과"),
    FINAL_WINNER("최종 우승자 : ");

    private final String outputMessage;

    OutputMessages(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getMessage() {
        return outputMessage;
    }
}
