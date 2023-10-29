package racingcar.model;

import racingcar.constants.ErrorMessage;
import racingcar.constants.RoundConstant;
import java.util.regex.Pattern;

public class Round {

    private final int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round from(String round) {
        validateIsNumber(round);
        validateIsNotZero(round);
        return new Round(Integer.parseInt(round));
    }

    public int getRound() {
        return round;
    }

    private static void validateIsNumber(String input) {
        if (!Pattern.matches(RoundConstant.NUMBER_PATTERN.getValue(), input)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_NOT_NATURAL_NUMBER.getMessage());
        }
    }

    private static void validateIsNotZero(String input) {
        if (input.equals(RoundConstant.ZERO.getValue())) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_NOT_NATURAL_NUMBER.getMessage());
        }
    }
}
