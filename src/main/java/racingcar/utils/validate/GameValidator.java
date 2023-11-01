package racingcar.utils.validate;

import static racingcar.constant.ExceptionMessage.ROUND_MUST_BE_POSITIVE;

public class GameValidator {

    public static void validateRoundNum(int roundNum) {
        if (checkNumIsZeroOrNegative(roundNum)) {
            throw new IllegalArgumentException(ROUND_MUST_BE_POSITIVE.getMessage());
        }
    }

    private static boolean checkNumIsZeroOrNegative(int num) {
        return num <= 0;
    }
}