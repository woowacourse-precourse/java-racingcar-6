package racingcar.domain.race;

import racingcar.constants.ErrorConsts;

public record Count(
        int count
) {
    private static final int MIN_COUNT = 1;

    public Count {
        validate(count);
    }

    private void validate(final int count) {
        validateMin(count);
    }

    private void validateMin(final int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException(ErrorConsts.INSUFFICIENT_RACE_COUNT.getFormattedMessage(MIN_COUNT));
        }
    }
}
