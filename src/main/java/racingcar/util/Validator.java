package racingcar.util;

import static racingcar.constants.ErrorCode.INVALID_INPUT;
import static racingcar.constants.ErrorCode.INVALID_NAME_LENGTH;

public class Validator {

    public boolean validateLengthOfName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH.toString());
        }
        return true;
    }

    public void checkIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT.toString());
        }
    }
}
