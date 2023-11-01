package racingcar.util;

import java.util.Arrays;

import static racingcar.util.ErrorMessage.*;
import static racingcar.util.ExceptionHandler.triggerException;

public class InputValidator {

    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    public static void validateCarsInput(String input) {
        if (input.isEmpty()) {
            triggerException(CAR_INPUT_EMPTY_STRING);
        }

        String[] split = Converter.convertSplitArray(input);

        if (!isValidCarsLengthOfName(split)) {
            triggerException(CAR_INPUT_EXCEED_NAME_LIMIT_LENGTH);
        }

        if (hasDuplicateCarName(split)) {
            triggerException(CAR_INPUT_DUPLICATE_CAR_NAME);
        }

        if (hasOnlySpaceCarName(split)) {
            triggerException(CAR_INPUT_ONLY_SPACE_CAR_NAME);
        }
    }

    private static boolean isValidCarsLengthOfName(String[] split) {
        return Arrays.stream(split)
                .filter(s -> s.length() > CAR_NAME_LENGTH_LIMIT)
                .findAny()
                .isEmpty();
    }

    public static boolean isPositive(int value) {
        return value >= 1;
    }

    private static boolean hasDuplicateCarName(String[] carNames) {
        return Arrays.stream(carNames)
                .distinct()
                .count() != carNames.length;
    }

    private static boolean hasOnlySpaceCarName(String[] carNames) {
        return Arrays.stream(carNames)
                .anyMatch(name -> name.replace(" ", "")
                        .isEmpty());
    }
}
