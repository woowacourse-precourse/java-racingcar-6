package racingcar.domain.wrapper;

import static racingcar.handler.ConstantsHandler.MIN_TRY_COUNT;
import static racingcar.handler.ErrorHandler.INVALID_NUMBER;
import static racingcar.handler.ErrorHandler.INVALID_RANGE;

public class TryCount {

    private final int count;

    private TryCount(String tryCount) {
        count = validateType(tryCount);
        validateRange(count);
    }

    public static TryCount create(String tryCount) {
        return new TryCount(tryCount);
    }

    private int validateType(String tryCount) {
        try {
            int count = Integer.parseInt(tryCount);
            return count;
        } catch (Exception e) {
            throw INVALID_NUMBER.getException();
        }
    }

    private void validateRange(int count) {
        if (count < MIN_TRY_COUNT) {
            throw INVALID_RANGE.getException();
        }
    }

    public int getTryCount() {
        return count;
    }
}
