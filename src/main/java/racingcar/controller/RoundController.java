package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Validator;

public class RoundController {
    public static int setRound() {

        try {
            int number = Integer.parseInt(Console.readLine());
            Validator.validateAttempts(number);

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
