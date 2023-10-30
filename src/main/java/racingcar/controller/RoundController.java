package racingcar.controller;

import racingcar.Constants;
import racingcar.Util;
import racingcar.model.Validator;

public class RoundController {

    public static int setRound() {
        int number = readRoundFromUser();
        Validator.validateAttempts(number);
        return number;
    }

    private static int readRoundFromUser() {
        try {
            return Integer.parseInt(Util.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.INVALID_ROUND_INPUT_ERROR);
        }
    }
}
