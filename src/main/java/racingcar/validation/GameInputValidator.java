package racingcar.validation;

import static racingcar.view.InputView.DELIMITER;

import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public final class GameInputValidator {

    private GameInputValidator() {
    }

    public static void validateIsPositiveInteger(String input) {
        try {
            int number = Integer.parseInt(input);
            checkIsPositiveNumber(number);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(ErrorMessage.INVALID_INPUT_NUMBER);
        }
    }

    private static void checkIsPositiveNumber(int number) {
        if (number <= 0) {
            throw new InvalidInputException(ErrorMessage.INVALID_INPUT_NUMBER);
        }
    }

    public static void validationCarNames(String input) {
        checkForComma(input);

        String[] racingCarNames = input.split(DELIMITER);
        for (String racingCarName : racingCarNames) {
            checkSpacesBetweenCommaAndCarName(racingCarName);
            checkCarNameLength(racingCarName);
            checkForEmptyCarNames(racingCarName);
        }
    }

    private static void checkForComma(String input) {
        if (!input.contains(DELIMITER)) {
            throw new InvalidInputException(ErrorMessage.INVALID_CAR_NAMES);
        }
    }

    private static void checkSpacesBetweenCommaAndCarName(String racingCarName) {
        if (!racingCarName.trim().equals(racingCarName)) {
            throw new InvalidInputException(ErrorMessage.INVALID_SPACES_BETWEEN_COMMA);
        }
    }

    private static void checkCarNameLength(String racingCarName) {
        if (racingCarName.length() > 5) {
            throw new InvalidInputException(ErrorMessage.INVALID_CAR_NAME_LENGTH);
        }
    }

    private static void checkForEmptyCarNames(String racingCarName) {
        if (racingCarName.isEmpty()) {
            throw new InvalidInputException(ErrorMessage.INVALID_CAR_NAME_EMPTY);
        }
    }

}
