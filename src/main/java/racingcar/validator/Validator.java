package racingcar.validator;

import org.junit.platform.commons.util.StringUtils;

import static racingcar.constant.Constants.*;

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

    public void validRepeatCnt(int repeatCnt) {
        if (repeatCnt <= MIN_REPEAT_CNT || MAX_REPEAT_CNT < repeatCnt)
            throw new IllegalArgumentException(ERROR_INVALID_REPEAT_COUNT);
    }
}
