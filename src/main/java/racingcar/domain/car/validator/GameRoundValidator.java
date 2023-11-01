package racingcar.domain.car.validator;

import racingcar.constant.errorMessage.ErrorMessages;
import racingcar.constant.errorMessage.InvalidArgumentException;

public class GameRoundValidator {

    private static final int ALLOWED_MIN_GAME_ROUND_COUNT = 1;

    private GameRoundValidator() {
    }

    public static void validateGameRoundCount(final int count) {
        validateGameRoundIsNegative(count);
    }

    private static void validateGameRoundIsNegative(final int count) {
        if (isNegative(count)) {
            throw new InvalidArgumentException(ErrorMessages.ROUND_IS_NOT_POSITIVE);
        }
    }

    private static boolean isNegative(final int count) {
        return count < ALLOWED_MIN_GAME_ROUND_COUNT;
    }
}
