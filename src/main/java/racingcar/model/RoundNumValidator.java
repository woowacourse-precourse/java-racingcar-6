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
        if (!Constants.roundNumPattern.matcher(roundNumString).matches()) {
            throw new IllegalArgumentException("1 이상의 숫자여야합니다");
        }
    }
}
