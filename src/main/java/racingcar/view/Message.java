package racingcar.view;

public enum Message {
    INPUT_CARNAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_RACECOUNT_MESSAGE("시도할 회수는 몇회인가요?"),
    OUTPUT_RESULT_MESSAGE("\n실행 결과");
    private final String msg;

    private Message(String msg) {
        this.msg = msg;
    }

    public String getValue() {
        return msg;
    }
}