package racingcar.util;

import static racingcar.util.ErrorMessage.*;
import static racingcar.util.ExceptionHandler.*;

public class Converter {
    private static final int INVALID_INPUT_FLAG = -1;
    private static final String SPLIT_REGEX = ",";

    public static int convertToValidInteger(String input) {
        int tryCount = convertStringToInteger(input);

        if (tryCount == INVALID_INPUT_FLAG) {
            triggerException(TRY_COUNT_NOT_A_NUMBER);
        }

        if (!InputValidator.isPositive(tryCount)) {
            triggerException(TRY_COUNT_NOT_A_POSITIVE_INTEGER);
        }

        return tryCount;
    }

    private static int convertStringToInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return INVALID_INPUT_FLAG;
        }
    }

    public static String[] convertSplitArray(String input) {
        return input.split(SPLIT_REGEX);
    }

}
