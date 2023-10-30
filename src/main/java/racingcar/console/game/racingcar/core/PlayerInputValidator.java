package racingcar.console.game.racingcar.core;

import racingcar.console.game.racingcar.constants.ExceptionMessages;

public class PlayerInputValidator {
    public void carListValidate(String carListString) {
        for (String carName : carListString.split(",")) {
            if (carName.length() > 5)
                throw new IllegalArgumentException(ExceptionMessages.INVALID_EXCEED_FIVE + carName);
        }
    }

    public void totalRoundValidate(String totalRoundString) {
        try {
            Integer.parseInt(totalRoundString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NOT_INTEGER + totalRoundString);
        }
    }
}
