package racingcar.utils;

import racingcar.exception.ErrorMessage;

public class TotalRoundValidator {
    public static int validateTotalRound(String input) {
        int totalRound = validateNumeric(input);
        validateIfZero(totalRound);
        return totalRound;
    }

    private static int validateNumeric(String input) {
        int totalRound;
        try {
            totalRound = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TOTAL_ROUND_ERROR.getMessage());
        }
        return totalRound;
    }

    private static void validateIfZero(int totalRound) {
        if (totalRound == 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TOTAL_ROUND_ERROR.getMessage());
        }
    }
}
