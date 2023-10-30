package racingcar.game.inputgenerateManager;

import java.util.HashSet;
import java.util.Set;
import racingcar.game.enums.InputSize;
import racingcar.game.exception.IllegalBlankException;
import racingcar.game.exception.IllegalDuplicateException;
import racingcar.game.exception.IllegalLengthException;
import racingcar.game.exception.IllegalRangeException;
import racingcar.game.exception.IllegalTypeException;

public class InputValidator {

    private static final String NUMERIC_REGEX = "\\d+";

    public static void validateNumber(String rawString) {
        validateIsNumeric(rawString);
        validateNumberRange(rawString);
    }

    private static void validateIsNumeric(String rawString) {
        if (!rawString.matches(NUMERIC_REGEX)) {
            throw new IllegalTypeException();
        }
    }

    private static void validateNumberRange(String rawString) {
        try {
            Integer.parseInt(rawString);
        } catch (NumberFormatException e) {
            throw new IllegalRangeException();
        }
    }


    public static void validateName(String[] nameArray) {
        validateStringLength(nameArray);
        validateIsBlankFromArray(nameArray);
        validateDuplicateName(nameArray);
    }

    private static void validateStringLength(String[] nameArray) {
        for (String string : nameArray) {
            if (string.length() > InputSize.MAX_SIZE.getSize()) {
                throw new IllegalLengthException();
            }
        }
    }

    public static void validateIsBlankFromString(String rawString) {
        if (rawString.isBlank()) {
            throw new IllegalBlankException();
        }
    }

    private static void validateIsBlankFromArray(String[] nameArray) {
        for (String name : nameArray) {
            if (name.isBlank()) {
                throw new IllegalBlankException();
            }
        }
    }

    private static void validateDuplicateName(String[] nameArray) {
        Set<String> nameSet = new HashSet<>();
        for (String name : nameArray) {
            if (!nameSet.add(name)) {
                throw new IllegalDuplicateException();
            }
        }
    }
}
