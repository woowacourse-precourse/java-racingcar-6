package racingcar.game.inputgenerateManager;

import java.util.IllegalFormatException;
import racingcar.game.enums.InputSize;
import racingcar.game.exception.IllegalBlankException;
import racingcar.game.exception.IllegalLengthException;
import racingcar.game.exception.IllegalRangeException;
import racingcar.game.exception.IllegalTypeException;

public class InputValidator {

    private static final String NUMERIC_REGEX = "\\d+";

    public static void validateIsNumeric(String rawString) {
        if (!rawString.matches(NUMERIC_REGEX)) {
            throw new IllegalTypeException();
        }
        validateRange(rawString);
    }

    public static void validateLength(String[] splitString) {
        for (String string : splitString) {
            if (string.length() > InputSize.MAX_SIZE.getSize()) {
                throw new IllegalLengthException();
            }
        }
    }

    public static void validateIsBlank(String rawString) {
        if (rawString.isBlank()) {
            throw new IllegalBlankException();
        }
    }

    public static void validateRange(String rawString) {
        try {
            Integer.parseInt(rawString);
        } catch (NumberFormatException e) {
            throw new IllegalRangeException();
        }
    }
}
