package racingcar.validator;

import org.junit.platform.commons.util.StringUtils;

import static racingcar.constant.Constants.ERROR_INVALID_CAR_NAME;
import static racingcar.constant.Constants.NAMES_MAX_LENGTH;

public class Validator {
    public void validateCarName(String carName) {
        if (isCarNameInvalid(carName)) {
            throw new IllegalArgumentException(ERROR_INVALID_CAR_NAME);
        }
    }

    public boolean isCarNameInvalid(String carName) {
        return carName.length() > NAMES_MAX_LENGTH;
    }

    public void validateInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(ERROR_INVALID_CAR_NAME);
        }
    }
}
