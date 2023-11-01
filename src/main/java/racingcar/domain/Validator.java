package racingcar.domain;

import racingcar.controller.RacingGame;

public class Validator {
    private Validator() {
    }

    public static boolean noName(String name) {
        return name == null || name.trim().isEmpty();
    }

    public static boolean oneCarNames(String carNames) {
        return carNames.split(",").length < 2;
    }

    public static boolean isNumber(String input) {
        try {
            int num = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isZero(int attempt) {
        return attempt == 0;
    }

    public static boolean isNegative(int attempt) {
        return attempt < 0;
    }

    public static boolean checkCarNames(String carNames) {
        if (Validator.noName(carNames)) {
            RacingGame.exception(ErrorMessage.NO_NAME);
        } else if (Validator.oneCarNames(carNames)) {
            RacingGame.exception(ErrorMessage.ONE_NAME);
        } else if (Validator.isNumber(carNames)) {
            RacingGame.exception(ErrorMessage.IS_NUMBER);
        }

        return true;
    }

    public static boolean checkAttempt(int numberOfAttempts) {
        if (Validator.isZero(numberOfAttempts)) {
            RacingGame.exception(ErrorMessage.IS_ZERO);
        } else if (Validator.isNegative(numberOfAttempts)) {
            RacingGame.exception(ErrorMessage.IS_NEGATIVE);
        }

        return true;
    }
}
