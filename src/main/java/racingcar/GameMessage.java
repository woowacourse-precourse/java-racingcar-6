package racingcar;

enum GameMessage {
    GAME_START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_NUMBER("시도할 회수는 몇회인가요?"),
    FINAL_WINNER("최종 우승자 : ");

    final String message;

    GameMessage(final String message) {
        this.message = message;
    }
}
