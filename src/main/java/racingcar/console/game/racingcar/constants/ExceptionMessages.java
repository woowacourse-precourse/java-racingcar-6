package racingcar.console.game.racingcar.constants;

public class ExceptionMessages {

    public static final String INVALID_NOT_INTEGER = "입력값이 정수가 아닙니다" + GameConstants.DELIMITER;
    public static final String INVALID_CAR_NAME = String.format("자동차의 이름은 %d자 이하여야 합니다" + GameConstants.DELIMITER, GameConstants.MAX_CHARACTER_COUNT);

}
