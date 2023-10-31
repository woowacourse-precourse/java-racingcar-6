package racingcar.enums;

public enum OutputMessage {

    GAME_RESULT_INFO_MESSAGE("실행 결과"),
    NAME_POSITION_DELIMITER(" : "),
    RACE_MARK("-"),
    WINNER_INFO_MESSAGE("최종 우승자");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }
}
