package racingcar.controller;

public class RoundNumberValidator {
    private static final String ROUND_NUMBER_ERROR_MESSAGE = "라운드는 1 이상이어야 합니다.";
    private static final int MIN_ROUND_NUMBER = 1;

    public static void validate(String roundNumber) {
        if (!roundNumber.matches("[0-9]+")) {
            throw new IllegalArgumentException(ROUND_NUMBER_ERROR_MESSAGE);
        }

        if ((Integer.parseInt(roundNumber)) < MIN_ROUND_NUMBER) {
            throw new IllegalArgumentException(ROUND_NUMBER_ERROR_MESSAGE);
        }
    }
}
