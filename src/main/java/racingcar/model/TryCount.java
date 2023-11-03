package racingcar.model;

import racingcar.validator.Validator;

public class TryCount {
    private final int tryCount;

    public TryCount(String stringTryCount) {
        this.tryCount = convertStringToInt(stringTryCount);
        Validator.checkInputNumberPositive(this.tryCount);

    }

    public boolean isSame(int tryCount) {
        return this.tryCount == tryCount;
    }

    private int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
