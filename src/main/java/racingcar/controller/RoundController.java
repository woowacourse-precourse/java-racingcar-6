package racingcar.controller;

import racingcar.Util;
import racingcar.model.Validator;

public class RoundController {
    public static int setRound() {

        try {
            int number = Integer.parseInt(Util.readLine());
            Validator.validateAttempts(number);

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
