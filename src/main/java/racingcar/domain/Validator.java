package racingcar.domain;

import racingcar.controller.RacingGame;

public class Validator {
    private Validator() {
    }

    /* for carNames */
    public static void checkCarNames(String carNames) {
        if (isEmpty(carNames)) {
            RacingGame.exception(ErrorMessage.NO_NAME);
        } else if (isNumber(carNames)) {
            RacingGame.exception(ErrorMessage.IS_NUMBER);
        } else if (isOneString(carNames)) {
            RacingGame.exception(ErrorMessage.ONE_NAME);
        }
    }

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

    /* for Car.name */
    public static void checkNameRestriction(String name) {
        if (isLongerFive(name)) {
            RacingGame.exception(ErrorMessage.NAME_RESTRICTION);
        }
    }

    private static boolean isLongerFive(String name) {
        return name.length() > 5;
    }

    /* for attemptCount */
    public static void checkAttemptCount(int attemptCount) {
        if (isZero(attemptCount)) {
            RacingGame.exception(ErrorMessage.IS_ZERO);
        } else if (isNegative(attemptCount)) {
            RacingGame.exception(ErrorMessage.IS_NEGATIVE);
        }
    }

    private static boolean isZero(int attemptCount) {
        return attemptCount == 0;
    }

    private static boolean isNegative(int attemptCount) {
        return attemptCount < 0;
    }
}
