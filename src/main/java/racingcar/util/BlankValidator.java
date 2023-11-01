package racingcar.util;

import static racingcar.exception.ExceptionMessage.INPUT_IS_BLANK;

public class BlankValidator {

    public static void validateBlank(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(INPUT_IS_BLANK);
        }
    }

    public static boolean isBlank(String input) {
        return input.isBlank();
    }
}
