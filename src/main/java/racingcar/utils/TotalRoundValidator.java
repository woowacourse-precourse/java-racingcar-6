package racingcar.utils;

import racingcar.exception.ErrorMessage;

public class TotalRoundValidator {
    private static final int MINIMUM_TOTAL_ROUND = 1;

    public static int validateTotalRound(String input) {
        //TODO Integer.parseInt() 의 중복을 피하기 위해 이렇게 작성하였는데, 다른 더 좋은 방식이 있을까?
        int totalRound = validateNumeric(input);
        validatePositive(totalRound);
        return totalRound;
    }

    private static int validateNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TOTAL_ROUND_ERROR.getMessage());
        }
    }

    private static void validatePositive(int totalRound) {
        if (totalRound < MINIMUM_TOTAL_ROUND) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TOTAL_ROUND_ERROR.getMessage());
        }
    }
}
