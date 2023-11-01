package racingcar.message;

import racingcar.GameConfig;

public class ErrorMessage {
    public static final String CAR_NAME_LENGTH = "자동차 이름은 " + GameConfig.CAR_NAME_MAX_LENGTH + "자 이하만 가능합니다.";
    public static final String CAR_NAME_DUPLICATE = "더 이상 전진할 수 없습니다.";
    public static final String GAME_NOT_FINISHED = "아직 게임이 종료되지 않았습니다.";
    public static final String NO_WINNER_EXISTS = "우승자가 존재하지 않습니다.";
}