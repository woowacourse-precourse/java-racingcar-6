package racingcar.util.message;

import racingcar.util.EnumUtil;

public enum OutputMessage implements EnumUtil<String, String> {

    NAME_POSITION_DELIMITER(" : ")
    , RACE_MARK("-")
    , WINNER_DELIMITER(", ")
    , RESULT_MESSAGE("실행 결과\n")
    , WINNER_MESSAGE("최종 우승자 : ");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return message;
    }
}
