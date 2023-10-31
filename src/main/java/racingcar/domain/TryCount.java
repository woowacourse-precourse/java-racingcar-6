package racingcar.domain;

import racingcar.utils.Constants;

public class TryCount {

    private final int count;

    public TryCount(String count) {
        validateCountIsNumber(count);
        validateMinTryCount(count);
        this.count = Integer.parseInt(count);
    }

    public void validateCountIsNumber(String count) {
        if (!count.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(Constants.ERROR_TRY_COUNT_NUM);
        }
    }

    public void validateMinTryCount(String count) {
        if (Integer.parseInt(count) < Constants.MIN_TRY_COUNT) {
            throw new IllegalArgumentException(Constants.ERROR_TRY_COUNT_MIN);
        }
    }

    public int getCount() {
        return count;
    }
}
