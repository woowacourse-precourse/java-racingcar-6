package racingcar.domain;

import racingcar.message.ErrorMessage;

public record TrialCount(int count) {
    public TrialCount {
        validateTrial(count);
    }

    private void validateTrial(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRIAL_COUNT);
        }
    }
}
