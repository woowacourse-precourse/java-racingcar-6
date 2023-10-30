package racingcar.utils.validator;

import racingcar.utils.types.NumberUtils;
import racingcar.utils.types.StringUtils;

public class RaceCountValidator extends CommonValidator{

    public static final long RACING_COUNT_MIN_VALUE = 1L;

    @Override
    public void validate(final String value) {
        super.validate(value);
        this.validateIsNumeric(value);
        this.validateRange(value);
    }


    private void validateIsNumeric(final String value) {
        if (!StringUtils.isNumeric(value)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(final String value) {
        if (!NumberUtils.isInRange(Long.valueOf(value), RACING_COUNT_MIN_VALUE, Long.MAX_VALUE)) {
            throw new IllegalArgumentException();
        }
    }
}
