package racingcar.vo;

import racingcar.validator.RacingRoundCountValidator;

public final class RacingRoundCount {

    private final int value;

    public RacingRoundCount(final String count) {
        RacingRoundCountValidator.validate(count);
        this.value = Integer.parseInt(count);
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RacingRoundCount racingRoundCount = (RacingRoundCount) o;
        return value == racingRoundCount.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
