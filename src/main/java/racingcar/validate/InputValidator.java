package racingcar.validate;

import static racingcar.constant.ExceptionConstant.NAME_LENGTH_NOT_IN_RANGE;
import static racingcar.constant.InputNumConstant.MAX_NAME_LENGTH;
import static racingcar.constant.InputNumConstant.MIN_NAME_LENGTH;

public class InputValidator {

    public static void validateName(String[] nameArr) {
        for (String name: nameArr) {
            if (!checkNameLengthInRange(name)) {
                throw new IllegalArgumentException(NAME_LENGTH_NOT_IN_RANGE.getValue());
            }
        }
    }

    private static boolean checkNameLengthInRange(String name) {
        return name.length() >= MIN_NAME_LENGTH.getValue() && name.length() <= MAX_NAME_LENGTH.getValue();
    }
}
