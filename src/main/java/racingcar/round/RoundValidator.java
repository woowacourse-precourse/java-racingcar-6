package racingcar.round;

import racingcar.Constant;

public class RoundValidator {

    public static boolean roundValidation(String round) {
        try {
            isNumber(round);
            isPositiveNumber(round);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static void isNumber(String round) {
        for (int i = 0; i < round.length(); i++) {
            if (!Character.isDigit(round.charAt(i))) {
                throw new IllegalArgumentException(Constant.ROUND_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    private static void isPositiveNumber(String round) {
        int num = Integer.parseInt(round);
        if (num < Constant.MINIMUM_ROUND_NUMBER) {
            throw new IllegalArgumentException(Constant.ROUND_NON_POSITIVE_MESSAGE);
        }
    }
}
