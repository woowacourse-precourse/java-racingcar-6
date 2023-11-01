package validator;

import java.util.HashSet;
import java.util.Set;
import message.ErrorMessage;

public class InputValidator {
    static int MAX_RACING_CAR_NAME_LENGTH = 5;
    static int MIN_MOVE_COUNT = 1;
    public static void validateRacingCarNames(String[] racingCarNames) {
        Set<String> uniqueRacingCarNames = new HashSet<>();
        for (String racingCarName : racingCarNames) {
            if (!isValidLength(racingCarName)) {
                throw new IllegalArgumentException(ErrorMessage.TOO_LONG_NAME_LENGTH_ERROR_MESSAGE.getMessage());
            }
            if (uniqueRacingCarNames.contains(racingCarName)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME_ERROR.getMessage());
            }
            uniqueRacingCarNames.add(racingCarName);
        }
    }

    public static void validateMoveCount(String moveCountInput) {
        try {
            int moveCount = Integer.parseInt(moveCountInput);
            if (moveCount < MIN_MOVE_COUNT) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC_INPUT_ERROR.getMessage());
        }
    }

    static boolean isValidLength(String racingCarName) {
        if (racingCarName.length() > MAX_RACING_CAR_NAME_LENGTH) {
            return false;
        }
        return true;
    }
}
