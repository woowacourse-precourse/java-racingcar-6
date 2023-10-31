package racingcar.domain.game.car;

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
        if (trialCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1이상이어야 합니다.");
        }
    }

    public int getTrialCount() {
        return trialCount;
    }
}
