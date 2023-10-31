package racingcar.validator;

import racingcar.view.RoundCountErrorMessage;

public class RoundCountValidator {

    public void validateInputGameRound(String inputRound) {
        int round = validateNotInteger(inputRound);
        validateNotPositive(round);
    }

    private int validateNotInteger(String inputRound) {
        int round;
        try {
            round = Integer.parseInt(inputRound);
        } catch (Exception e) {
            throw new IllegalArgumentException(RoundCountErrorMessage.NOT_INTEGER_ERROR_MESSAGE);
        }
        return round;
    }

    private void validateNotPositive(int round) {
        if (round <= 0) {
            throw new IllegalArgumentException(RoundCountErrorMessage.NOT_POSITIVE_ERROR_MESSAGE);
        }
    }
}
