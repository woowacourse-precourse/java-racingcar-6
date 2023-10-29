package racingcar.contant;

public enum GameNotice {
    GAME_START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    ROUND_NUMBER("시도할 회수는 몇회인가요?\n"),
    EXECUTE_RESULT("\n실행 결과\n"),
    NOTICE_WINNER_RESULT("최종 우승자 : ");

    private final String message;

    GameNotice(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
