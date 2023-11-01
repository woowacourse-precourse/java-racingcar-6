package racingcar.domain;

import racingcar.controller.RacingGame;

public class Validator {
    private Validator() {
    }

    /* for carNames */
    public static boolean isEmpty(String name) {
        return name == null || name.trim().isEmpty();
    }

    public static boolean isNumber(String input) {
        try {
            int num = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isOneString(String carNames) {
        return carNames.split(",").length < 2;
    }

    public static void checkCarNames(String carNames) {
        if (Validator.isEmpty(carNames)) {
            RacingGame.exception(ErrorMessage.NO_NAME);
        } else if (Validator.isNumber(carNames)) {
            RacingGame.exception(ErrorMessage.IS_NUMBER);
        } else if (Validator.isOneString(carNames)) {
            RacingGame.exception(ErrorMessage.ONE_NAME);
        }
    }

    /* for Car.name */

    public static boolean isShorterFive(String name) {
        return name.length() > 5;
    }

    public static void checkNameRestriction(String name) {
        if (isShorterFive(name)) {
            RacingGame.exception(ErrorMessage.NAME_RESTRICTION);
        }
    }

    /* for numberOfAttempts */

    public static boolean isZero(int attempt) {
        return attempt == 0;
    }

    public static boolean isNegative(int attempt) {
        return attempt < 0;
    }

    public static void checkAttempt(int numberOfAttempts) {
        if (Validator.isZero(numberOfAttempts)) {
            RacingGame.exception(ErrorMessage.IS_ZERO);
        } else if (Validator.isNegative(numberOfAttempts)) {
            RacingGame.exception(ErrorMessage.IS_NEGATIVE);
        }
    }
}
