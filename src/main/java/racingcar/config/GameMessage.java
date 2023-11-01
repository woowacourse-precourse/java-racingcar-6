package racingcar.config;

public enum GameMessage {
    CAR_NAME_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ATTEMPT_COUNT_INPUT_MESSAGE("시도할 횟수는 몇회인가요?"),
    GAME_RESULT_MESSAGE("\n실행 결과"),
    ROUND_RESULT_FORM("%s : %s\n"),
    ONE_MOVE_DISTANCE("-"),
    EACH_ROUND_DELIM("\n"),
    WINNER_MESSAGE_PREFIX("최종 우승자 : ");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
