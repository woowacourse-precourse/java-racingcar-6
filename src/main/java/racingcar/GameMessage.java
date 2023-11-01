package racingcar;

public enum GameMessage {
    DELIMITER(", "),
    ASK_CARS_NAME("경주할 자동차 이름을 입력하세요.(이름은 %s기준으로 구분)", DELIMITER.message),
    ASK_ROUND_COUNT("시도할 회수는 몇회인가요?"),
    EXECUTION_RESULT("실행 결과"),
    FINAL_WINNER("최종 우승자 : "),
    EXECUTE_RESULT_SIGN("-"),
    COLON(" : ");

    private final String message;

    GameMessage(String message, String... args) {
        this.message = String.format(message, (Object) args);
    }

    public String getMessage() {
        return message;
    }
}
