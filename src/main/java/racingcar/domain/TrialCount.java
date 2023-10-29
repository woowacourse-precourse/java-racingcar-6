package racingcar.domain;

import racingcar.message.ErrorMessage;

public class TrialCount {
    private int count;

    public TrialCount(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NEGATIVE);
        }
    }

    public boolean moreThen(int count) {
        return this.count > count;
    }
}
