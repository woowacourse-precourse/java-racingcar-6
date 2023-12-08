package racingcar.type.message;

public enum MessageType {
    MARK("-"),
    NAME_SEPARATOR(","),

    ENTER_CAR_NAME("경주할 자동차 이름을 입력 하세요.(이름은 쉼표(,) 기준 으로 구분)"),
    ENTER_RACE_ROUND("시도할 회수는 몇 회 인가요"),
    ENTER_RACE_RESULT("\n실행 결과"),
    FINAL_WINNER("최종 우승자 : %s");

    private final String messageValue;

    MessageType(String messageValue) { this.messageValue = messageValue; }

    public String getMessageValue() { return messageValue; }
}
