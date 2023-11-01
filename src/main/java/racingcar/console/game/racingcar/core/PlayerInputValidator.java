package racingcar.console.game.racingcar.core;

import racingcar.console.game.racingcar.constants.ExceptionMessages;

import static racingcar.console.game.racingcar.constants.GameConstants.MAX_CHARACTER_COUNT;

public class PlayerInputValidator {
    public void validateCarList(String carListString) {
        for (String carName : carListString.split(",")) {
            if (carName.length() > MAX_CHARACTER_COUNT)
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CAR_NAME + carName);
        }
    }

    public void validateTotalRound(String totalRoundString) {
        try {
            Integer.parseInt(totalRoundString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NOT_INTEGER + totalRoundString);
        }
    }
}
