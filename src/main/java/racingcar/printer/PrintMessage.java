package racingcar.printer;

public enum PrintMessage {
    REQUEST_INPUT_RACING_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REQUEST_INPUT_TRY_COUNT("시도할 회수는 몇회인가요?"),
    NOTICE_RESULT("실행결과"),
    COLON(" : "),
    DASH("-"),
    COMMA(", "),
    NOTICE_WINNER("최종 우승자 : ");

    private final String value;

    public String getValue() {
        return this.value;
    }

    PrintMessage(String value) {
        this.value = value;
    }
}
