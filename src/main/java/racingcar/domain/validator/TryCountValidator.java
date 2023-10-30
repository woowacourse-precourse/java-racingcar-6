package racingcar.domain.validator;

import static racingcar.constant.MessageConstants.TRY_COUNT_NOT_INTEGER;
import static racingcar.constant.MessageConstants.TRY_COUNT_NOT_POSITIVE;
import static racingcar.constant.MessageConstants.TRY_COUNT_NOT_PROVIDED;

public class TryCountValidator {

    private final String tryCount;

    public TryCountValidator(String tryCount) {
        this.tryCount = tryCount;
        validateAll();
    }

    public void validateAll() {
        validateTryCountExists();
        validateTryCountIsInteger();
        validateTryCountIsPositive();
    }

    private void validateTryCountExists() {
        if (tryCount.isBlank()) {
            throw new IllegalArgumentException(TRY_COUNT_NOT_PROVIDED);
        }
    }

    private void validateTryCountIsInteger() {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_NOT_INTEGER);
        }
    }

    private void validateTryCountIsPositive() {
        if (Integer.parseInt(tryCount) <= 0) {
            throw new IllegalArgumentException(TRY_COUNT_NOT_POSITIVE);
        }
    }

}
