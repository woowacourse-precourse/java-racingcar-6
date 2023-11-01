package racingcar.support.validator;

import racingcar.exceptions.argument.LessThanTryCountMinException;
import racingcar.support.SystemProperty;

public class TryCountValidator {

    private static final Long minTryCount = Long.valueOf(SystemProperty.MIN_TRY_COUNT);

    private TryCountValidator() {
    }

    public static Long validate(Long count) {
        if (count < minTryCount) {
            throw new LessThanTryCountMinException();
        }
        return count;
    }
}
