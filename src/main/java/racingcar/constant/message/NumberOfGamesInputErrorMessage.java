package racingcar.constant.message;

import racingcar.constant.GameConstant;

public class NumberOfGamesInputErrorMessage {
    public static final String INPUT_IS_EMPTY = "입력값 오류 : 시도 횟수는 적어도 한 자리 수 이상의 입력이어야 합니다.";
    public static final String INPUT_IS_NOT_NUMERIC_TYPE = "입력값 오류 : 시도 횟수는 숫자 형식의 입력이어야 합니다.";
    public static final String INPUT_IS_LOWER_THAN_LIMIT =
            "입력값 오류 : 시도 횟수는 " + GameConstant.NUMBER_OF_GAMES_LOWER_LIMIT + " 이상의 숫자여야 합니다.";
}