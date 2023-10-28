package racingcar.enums;

public enum OutputMessage {
    START_OF_RESULT("실행 결과"),
    RESULT_OF_CAR_FORWARD_FORMAT("%s : %s"),
    PROGRESS_BAR_OF_CAR_FORWARD("-"),
    WINNER_OF_THIS_GAME_FORMAT("최종 우승자 : %s");

    private String message;

    OutputMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
