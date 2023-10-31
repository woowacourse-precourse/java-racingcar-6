package racingcar.util;

import racingcar.validation.RoundValidator;

public class InputConverter {

    private InputConverter() {
    }

    public static int convertRoundStringToNumber(String input) {
        RoundValidator roundValidator = new RoundValidator();
        roundValidator.validateRound(input);
        return Integer.parseInt(input);
    }
}
