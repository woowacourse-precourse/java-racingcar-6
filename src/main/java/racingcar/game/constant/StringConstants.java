package racingcar.game.constant;

public enum StringConstants {
    PLAYER_PROMPT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT_PROMPT_MESSAGE("시도할 회수는 몇회인가요?"),
    GAME_RESULT_MESSAGE("실행 결과"),
    FINAL_WINNER_MESSAGE("최종 우승자");
    private final String message;

    StringConstants(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
