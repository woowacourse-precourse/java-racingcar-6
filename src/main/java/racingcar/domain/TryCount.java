package racingcar.domain;

import static racingcar.message.RacingCarErrorMessage.NOT_NATURAL_NUMBER_VALIDATE;

public class TryCount {

    private final int tryCount;

    public TryCount(final String tryCount) {
        isNaturalNumberValidate(tryCount);
        this.tryCount = convertStringToInt(tryCount);
    }

    private void isNaturalNumberValidate(String tryCount) {
        if (!tryCount.matches("^[1-9]\\d*$")){
            throw new IllegalArgumentException(NOT_NATURAL_NUMBER_VALIDATE.getMessage());
        }
    }

    private int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public int getTryCount() {
        return tryCount;
    }
}
