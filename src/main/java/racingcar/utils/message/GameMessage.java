package racingcar.utils.message;

public enum GameMessage {
    REQUEST_CAR_NAMES_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REQUEST_GAME_ROUND_MESSAGE("시도할 회수는 몇회인가요?"),
    RESULT_MESSAGE("실행 결과"),
    FINAL_WINNER_MESSAGE("최종 우승자 : "),
    ROUND_RESULT("%s : %s"),
    DISTANCE_SYMBOL("-"),
    NEW_LINE("\n");

    private String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
