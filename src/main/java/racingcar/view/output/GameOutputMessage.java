package racingcar.view.output;

public enum GameOutputMessage {
    RACE_START("실행 결과"),
    WINNER_RESULT("최종 우승자 : "),
    DISTANCE_INDICATOR("-"),
    GAME_PROCEEDING("%s : %s\n"),
    ;

    String message;

    GameOutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
