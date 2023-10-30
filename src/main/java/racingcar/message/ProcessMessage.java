package racingcar.message;

public enum ProcessMessage {
    INPUT_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ATTEMPT_COUNT("시도할 회수는 몇회인가요?"),
    PROCESS_RESULT("실행 결과"),
    COMMA(", "),
    HYPHEN("-"),
    NEW_LINE("\n"),
    RECORD("%s : "),
    WINNER_TITLE("최종 우승자 : ");

    private final String message;

    ProcessMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
