package racingcar.domain.trial;

import racingcar.domain.trial.validate.PositiveIntegerValidator;

public class Trial {

    private static final int EXHAUSTED_TRIAL_COUNT = 0;

    private Integer trial;

    public Trial(Integer trial) {
        validate(trial);
        this.trial = trial;
    }

    private void validate(Integer trial) {
        PositiveIntegerValidator.validate(trial);
    }

    public void useTrialCount() {
        this.trial--;
    }

    public boolean isExhausted() {
        return trial.equals(EXHAUSTED_TRIAL_COUNT);
    }
}
