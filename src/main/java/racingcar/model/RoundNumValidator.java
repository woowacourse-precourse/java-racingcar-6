package racingcar.model;

import racingcar.Constants;

public record RoundNumValidator(String roundNumString) {

    public RoundNumValidator(String roundNumString) {
        this.roundNumString = roundNumString;
        validate();
    }

    public void validate() {
        checkInteger();
    }

    private void checkInteger() {
        if (!Constants.ROUND_NUM_PATTERN.matcher(roundNumString).matches()) {
            throw new IllegalArgumentException(Constants.ROUND_NUM_ERROR);
        }
    }
}
