package racingcar.controller;

import racingcar.Constants;
import racingcar.Util;
import racingcar.model.Validator;

public class RoundController {

    public static int getRoundFromUser(String input) {
        int number = readRoundFromUser(input);
        Validator.validateAttempts(number);
        return number;
    }

    private static int readRoundFromUser(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.INVALID_ROUND_INPUT_ERROR);
        }
    }
}
