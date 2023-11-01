package racingcar.domain;

import racingcar.controller.RacingGame;

public class Validator {
    private Validator() {
    }

    /* for carNames */
    private static boolean isEmpty(String canNames) {
        return canNames == null || canNames.trim().isEmpty();
    }

    private static boolean isNumber(String canNames) {
        try {
            int num = Integer.parseInt(canNames);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOneString(String carNames) {
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
    private static boolean isShorterFive(String name) {
        return name.length() > 5;
    }

    public static void checkNameRestriction(String name) {
        if (isShorterFive(name)) {
            RacingGame.exception(ErrorMessage.NAME_RESTRICTION);
        }
    }

    /* for attemptCount */
    private static boolean isZero(int attemptCount) {
        return attemptCount == 0;
    }

    private static boolean isNegative(int attemptCount) {
        return attemptCount < 0;
    }

    public static void checkAttemptCount(int attemptCount) {
        if (Validator.isZero(attemptCount)) {
            RacingGame.exception(ErrorMessage.IS_ZERO);
        } else if (Validator.isNegative(attemptCount)) {
            RacingGame.exception(ErrorMessage.IS_NEGATIVE);
        }
    }
}
