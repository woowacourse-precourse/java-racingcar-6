package racingcar.validator;

import racingcar.constant.ErrorMessage;
import racingcar.constant.FixedNumber;

public class RacingCarValidator {
    public void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > FixedNumber.MAX_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME.getMessage());
        }
    }
}
