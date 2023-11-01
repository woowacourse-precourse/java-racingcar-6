package racingcar.domain.game;


import static racingcar.global.enums.Constant.MIN_TRIAL_NUMBER;
import static racingcar.global.enums.ExceptionMessage.TRIAL_MINIMUM_MESSAGE;

public class Trial {

    private int trial;

    public Trial(int trial) {
        validateTrial(trial);
        this.trial = trial;
    }

    public int get() {
        return trial;
    }

    public void decreaseTrial() {
        trial -= 1;
    }

    public boolean isRemainTrial() {
        return trial > 0;
    }

    private void validateTrial(final int trial) {
        if (trial < MIN_TRIAL_NUMBER.getConstant()) {
            throw new IllegalArgumentException(TRIAL_MINIMUM_MESSAGE.getMessage());
        }
    }

}
