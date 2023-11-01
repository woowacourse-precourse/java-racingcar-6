package racingcar.domain.race;

import racingcar.constants.ErrorConsts;

public final class Count {
    private static final int MIN_COUNT = 1;
    private int count;

    public Count(String count) {
        final int parsedCount = parseToInt(count);
        validate(parsedCount);
        this.count = parsedCount;
    }

    public void decrease() {
        this.count--;
    }

    private void validate(final int count) {
        validateMin(count);
    }

    private void validateMin(final int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException(ErrorConsts.INSUFFICIENT_RACE_COUNT.getFormattedMessage(MIN_COUNT));
        }
    }

    private int parseToInt(final String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorConsts.NOT_NUMBER_FORMATTED.getMessage());
        }
    }
}
