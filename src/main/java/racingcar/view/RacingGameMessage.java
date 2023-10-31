package racingcar.view;

public enum RacingGameMessage {
    START_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),

    REQUEST_TRY_MESSAGE("시도할 회수는 몇회인가요?"),

    GAME_RESULT_MESSAGE("실행 결과"),

    WINNER_MESSAGE("최종 우승자 : "),

    NEWLINE("\n"),

    MOVE("-");

    private String name;

    RacingGameMessage(String name) {
        this.name = name;
    }

    public String getStartMessage() {
        return START_MESSAGE.name;
    }

    public String getRequestTryMessage() {
        return REQUEST_TRY_MESSAGE.name;
    }

    public String getGameResultMessage() {
        return NEWLINE.name + GAME_RESULT_MESSAGE.name;
    }

    public String getWinnerMessage(String winners) {
        return WINNER_MESSAGE.name + winners;
    }

    public String getNewLine() {
        return NEWLINE.name;
    }
    public String getMoveMessage() {
        return MOVE.name;
    }
}
