package racingcar.utils;

public enum RacingGameMessage {
    START_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),

    REQUEST_RACE_COUNT_MESSAGE("시도할 회수는 몇회인가요?"),

    GAME_RESULT_MESSAGE("실행 결과"),

    WINNER_MESSAGE("최종 우승자 : "),

    MOVE("-");

    private String message;

    RacingGameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String getWinnersMessage(final String winners) {

        return WINNER_MESSAGE.message + winners;
    }
}
