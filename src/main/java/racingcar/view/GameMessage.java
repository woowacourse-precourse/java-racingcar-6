package racingcar.view;

public enum GameMessage {
    START_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REQUEST_TRY_MESSAGE("시도할 회수는 몇회인가요?"),
    GAME_RESULT_MESSAGE("실행 결과"),
    WINNER_MESSAGE("최종 우승자 : ");

    private String name;

    GameMessage(String name) {
        this.name = name;
    }

    public String getStartMessage() {
        return START_MESSAGE.name;
    }

    public String getRequestTryMessage() {
        return REQUEST_TRY_MESSAGE.name;
    }

    public String getGameResultMessage() {
        return GAME_RESULT_MESSAGE.name;
    }

    public String getWinnerMessage() {
        return WINNER_MESSAGE.name;
    }
}
