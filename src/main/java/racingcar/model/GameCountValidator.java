package racingcar.model;

import static racingcar.utils.Constants.INTEGER_ERROR_MESSAGE;
import static racingcar.utils.Constants.INTEGER_NUMBER;
import static racingcar.utils.Constants.MIN_NUM;
import static racingcar.utils.Constants.NATURAL_NUMBER_ERROR_MESSAGE;

public class GameCountValidator {
    public static void validateGameCount(String gameCount) {
        validateIsInteger(gameCount);
        validateIsNaturalNumber(gameCount);
    }

    private static void validateIsInteger(String gameCount) {
        if (!gameCount.matches(INTEGER_NUMBER)) {
            throw new IllegalArgumentException(INTEGER_ERROR_MESSAGE);
        }
    }

    private static void validateIsNaturalNumber(String gameCount) {
        int count = Integer.parseInt(gameCount);
        if (count < MIN_NUM) {
            throw new IllegalArgumentException(NATURAL_NUMBER_ERROR_MESSAGE);
        }
    }
}
