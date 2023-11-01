package racingcar.enumType.message;

public enum OutputMessage {

    RESULT_MESSAGE("\n실행 결과")
    , WINNER_MESSAGE("최종 우승자");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }
}
