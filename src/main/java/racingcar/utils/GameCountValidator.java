package racingcar.utils;

import java.util.regex.Pattern;

public class GameCountValidator {

    private static final int MAX_GAME_COUNT = 10;
    private static final String POSITIVE_DIGIT_REGEX = "^[1-9]\\d*$";
    private static final String INVALID_POSITIVE_DIGIT_ERROR_MESSAGE = "게임 진행 횟수는 양의 정수만 입력할 수 있습니다.";
    private static final String MAX_GAME_COUNT_OVER_ERROR_MESSAGE = "게임 진행 횟수는 10이하의 수만 입력할 수 있습니다.";
    private GameCountValidator() {
    }

    public static void validatePositiveDigitAnInRangeGameCount(String gameCount) {
        isPositiveDigit(gameCount);
        isInRangeGameCount(gameCount);
    }

    private static void isPositiveDigit(String gameCount) {
        if (!Pattern.matches(POSITIVE_DIGIT_REGEX, gameCount)) {
            throw new IllegalArgumentException(INVALID_POSITIVE_DIGIT_ERROR_MESSAGE);
        }
    }

    private static void isInRangeGameCount(String gameCount) {
        if (Integer.parseInt(gameCount) > MAX_GAME_COUNT){
            throw new IllegalArgumentException(MAX_GAME_COUNT_OVER_ERROR_MESSAGE);
        }
    }
}
