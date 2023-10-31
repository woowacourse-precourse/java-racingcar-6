package racingcar.constant;

public enum Message {

    START_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    CYCLE_INPUT_MESSAGE("시도할 회수는 몇회인가요?"),
    RACING_RESULT("실행 결과"),
    COMMA_WITH_WHITESPACE(", "),
    FINAL_WINNERS("최종 우승자"),
    COLON_WITH_WHITESPACE(" : "),
    COMMA(",");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
