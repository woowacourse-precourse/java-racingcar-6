package racingcar.view;

public enum OutputMessage {
    PLAY_RESULT("실행 결과"),
    FINAL_RESULT("최종 우승자 : ");



    private final String outputMessage;

    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
