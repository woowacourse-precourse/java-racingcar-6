package racingcar.view;

public enum OutputViewMessage {
    OUTPUT_GAME_RESULT_MESSAGE("실행 결과"),
    OUTPUT_CAR_POSITION_MESSAGE_FORMAT("%s : %s"),
    OUTPUT_WINNER_MESSAGE("최종 우승자 : ");

    private final String message;

    OutputViewMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
