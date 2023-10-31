package racingcar.util;

import static racingcar.common.ExceptionMessage.*;

import java.util.List;
import racingcar.common.Config;

public class InputDataValidator {

    public static void validateInputSize(List<String> inputList) throws IllegalArgumentException {

        for (String input : inputList) {
            validateEachInputSizeOver(input);
            validateEachInputSizeZero(input);
        }

    }

    private static void validateEachInputSizeOver(String input) throws IllegalArgumentException {

        if (input.length() > Config.MAX_NAME_SIZE) {
            throw new IllegalArgumentException(SIZE_OVER);
        }

    }

    private static void validateEachInputSizeZero(String input) throws IllegalArgumentException {

        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY);
        }

    }

    public static void validateHasSpace(String input) throws IllegalArgumentException {

        if (input.contains(" ")) {
            throw new IllegalArgumentException(HAS_SPACE);
        }

    }

    public static void validateIsInteger(String input) throws IllegalArgumentException {

        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }

    }
}
