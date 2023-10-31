package racingcar.validator;

import static racingcar.constant.Constants.EXCEPTION_BLACK_INPUT;
import static racingcar.constant.Constants.EXCEPTION_CHAR_INPUT;

public class RoundNumberValidator {

    public static void validate(String readLine) {
        checkBlank(readLine);
        checkDigit(readLine);
    }

    private static void checkBlank(String readLine) {
        if (readLine.isBlank()) {
            throw new IllegalArgumentException(EXCEPTION_BLACK_INPUT);
        }
    }

    private static void checkDigit(String readLine) {
        for (int i = 0; i < readLine.length(); i++) {
            if (!Character.isDigit(readLine.charAt(i))) {
                throw new IllegalArgumentException(EXCEPTION_CHAR_INPUT);
            }
        }
    }
}
