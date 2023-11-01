package racingcar.io.output;

public enum OutputMessage {

    CAR_NAME_INPUT_GUIDE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    MOVING_COUNT_INPUT_GUIDE("시도할 회수는 몇회인가요?"),
    EXECUTION_RESULT("실행 결과");

    private final String literal;

    OutputMessage(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }

}
