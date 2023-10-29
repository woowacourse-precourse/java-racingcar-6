package racingcar.constants;

public enum OutputMessage {

    PLAY_RESULT_MESSAGE("\n실행 결과"),
    WINNER_MESSAGE("최종 우승자 :"),


    SPACE(" "),
    COLON(" : "),
    RESULT_CHARACTER("-");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
