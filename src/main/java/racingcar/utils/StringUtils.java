package racingcar.utils;

import racingcar.domain.Constants;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    public static List<String> splitCarNames(String carNames) {
        return Arrays.asList(carNames.split(Constants.COMMA)); // 한줄에 점하나만 찍는다 검증.
    }

    public static String joinWinnerCarName(List<String> winnerCarNames) {
        return String.join(Constants.WINNER_DELIMITER,winnerCarNames);
    }
}