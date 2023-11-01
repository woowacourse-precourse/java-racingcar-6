package racingcar.utils.validator;

import racingcar.utils.exception.CarExceptionType;
import racingcar.utils.exception.StringUtilsExceptionType;
import racingcar.utils.types.NumberUtils;
import racingcar.utils.types.StringUtils;

public class RaceCountValidator extends CommonValidator{

    public static final int RACING_COUNT_MIN_VALUE = 1;

    @Override
    public void validate(final String value) {
        super.validate(value);
        this.validateIsNumeric(value);
        this.validateRange(value);
    }


    private void validateIsNumeric(final String value) {
        if (!StringUtils.isNumeric(value)) {
            throw new IllegalArgumentException(CarExceptionType.NOT_NUMERIC.getMessage());
        }
    }

    private void validateRange(final String value) {
        if (!NumberUtils.isInRange(Integer.valueOf(value), RACING_COUNT_MIN_VALUE, Integer.MAX_VALUE)) {
            throw new IllegalArgumentException(StringUtilsExceptionType.OUT_OF_RANGE.getMessage());
        }
    }
}
