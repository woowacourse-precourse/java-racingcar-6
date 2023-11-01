package racingcar.utils;

import static racingcar.constant.InputConstant.TRAIL_LOW_BOUND;

import racingcar.constant.ErrorMessage;

public class Validator {
    public void validateTrial(int trial) {
        if(trial <= TRAIL_LOW_BOUND.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRIAL_NUMBER_ERROR.getMessage());
        }
    }
}