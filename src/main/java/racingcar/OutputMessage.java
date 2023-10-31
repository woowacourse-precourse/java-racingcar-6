package racingcar;

public enum OutputMessage {
    RACING_CAR_NAME_INPUT_REQUEST("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ROUND_COUNT_INPUT_REQUEST("시도할 회수는 몇회인가요?"),
    EXECUTION_RESULT("실행 결과"),
    GAME_RESULT ("최종 우승자 : %s");
    ;
    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
