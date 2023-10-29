package racingcar.vo;

import racingcar.validator.RoundCountValidator;

public final class RoundCount {

    private final int value;

    public RoundCount(final String count) {
        RoundCountValidator.validate(count);
        this.value = Integer.parseInt(count);
    }

    public int getValue() {
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

        RoundCount roundCount = (RoundCount) o;
        return value == roundCount.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
