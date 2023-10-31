package racingcar.model;

import racingcar.Constants;

public class RoundNumValidator {
    public final String ROUND_NUM_STRING;

    public RoundNumValidator(String roundNumString) {
        this.ROUND_NUM_STRING = roundNumString;
        validate();
    }

    public void validate() {
        if (!isValid()) {
            throw new IllegalArgumentException(Constants.ROUND_NUM_WRONG_ERROR);
        }
    }

    private boolean isValid() {
        return Constants.roundNumPattern.matcher(ROUND_NUM_STRING).matches();
    }
}