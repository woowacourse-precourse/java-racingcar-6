package racingcar.message;

public enum OutputMessage {

    RACE("-")
    , RESULT_MESSAGE("\n실행 결과")
    , WINNER_MESSAGE("최종 우승자 : ");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }
}