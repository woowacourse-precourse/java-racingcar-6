package racingcar.domain;

import racingcar.message.ErrorMessage;

public record TrialCount(int count) {

    public TrialCount {
        validate(count);
    }

    private void validate(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NEGATIVE);
        }
    }

    public boolean isMoreThen(int count) {
        return this.count > count;
    }
}
