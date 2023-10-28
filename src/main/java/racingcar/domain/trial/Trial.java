package racingcar.domain.trial;

public class Trial {
    
    private static final int EXHAUSTED_TRIAL_COUNT = 0;

    private Integer trial;

    public Trial(Integer trial) {
        this.trial = trial;
    }

    public void useTrialCount() {
        this.trial--;
    }

    public boolean isExhausted() {
        return trial.equals(EXHAUSTED_TRIAL_COUNT);
    }
}
