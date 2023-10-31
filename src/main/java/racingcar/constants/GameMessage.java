package racingcar.constants;

public enum GameMessage {
    INSTRUCTIONS_ENTERING_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INSTRUCTIONS_ENTERING_ATTEMPT_NUMBER("시도할 회수는 몇회인가요?"),
    OUTPUT_EXECUTION_RESULTS("\n실행 결과"),
    OUTPUT_WINNER_ANNOUNCEMENT("최종 우승자 : "),
    OUTPUT_DIVISION(", "),
    OUTPUT_COLON(" : "),
    OUTPUT_FORWARD("-");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
