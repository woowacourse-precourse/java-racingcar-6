package racingcar.model;

import java.util.regex.Pattern;

public class Round {

    private static final String NUMBER_PATTERN = "^[\\d]*$";
    private static final String ZERO = "0";
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
        if (!Pattern.matches(NUMBER_PATTERN, input)) {
            throw new IllegalArgumentException("자연수만 입력 가능합니다.");
        }
    }

    private static void validateIsNotZero(String input) {
        if (input.equals(ZERO)) {
            throw new IllegalArgumentException("자연수만 입력 가능합니다.");
        }
    }
}
