package racingcar.common.util;

import static racingcar.common.message.ErrorConstant.CAR_NAME_OVER_FIVE_ERROR_MESSAGE;

public class Validator {
    public boolean verifyCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_OVER_FIVE_ERROR_MESSAGE);
        }
        return true;
    }

    public boolean isInt(String numberString) {
        for (int i = 0; i < numberString.length(); i++) {
            char numberChar = numberString.charAt(i);
            if (!('0' <= numberChar && numberChar <= '9')) {
                return false;
            }
        }
        return true;
    }
}
