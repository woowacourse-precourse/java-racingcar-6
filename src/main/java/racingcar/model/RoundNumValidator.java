package racingcar.model;

import racingcar.constant.Constant;
import racingcar.constant.ErrorMessage;

public class RoundNumValidator {
    public final String ROUND_NUM_STRING;

    public RoundNumValidator(String roundNumString) {
        this.ROUND_NUM_STRING = roundNumString;
        validate();
    }

    public void validate() {
        isInt();
    }

    private void isInt() {
        if (!Constant.roundNumPattern.matcher(ROUND_NUM_STRING).matches()) {
            throw new IllegalArgumentException(ErrorMessage.ROUND_NUM_WRONG_ERROR);
        }
    }
}
