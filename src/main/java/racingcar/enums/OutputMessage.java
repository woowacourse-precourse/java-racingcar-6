package racingcar.enums;

public enum OutputMessage {

    CAR_NAME_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    TRY_COUNT_INPUT_MESSAGE("시도할 회수는 몇회인가요?\n");

    private final String outputMessage;

    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }

}
