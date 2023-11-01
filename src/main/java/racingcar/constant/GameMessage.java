package racingcar.constant;

public enum GameMessage {
    GAME_START_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_NUMBER_MESSAGE("시도할 횟수는 몇회인가요?"),
    RESULT_MESSAGE("실행 결과");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
