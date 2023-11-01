package racingcar.domain.car;

import racingcar.util.Err;

public class TrialCount {
    private final int trialCount;

    private TrialCount(int trialCount) {
        validatePositiveTrialCount(trialCount);
        this.trialCount = trialCount;
    }

    public static TrialCount from(int trialCount) {
        return new TrialCount(trialCount);
    }

    private void validatePositiveTrialCount(int trialCount) {
        if (trialCount < 0) {
            throw new IllegalArgumentException(Err.INSUFFICIENT_TRIAL_COUNT.getMessage());
        }
    }

    public int getTrialCount() {
        return trialCount;
    }

    public TrialCount decremented() {
        return new TrialCount(trialCount - 1);
    }
}
