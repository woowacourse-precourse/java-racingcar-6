package racingcar.domain.game;


import static racingcar.global.enums.Constant.MIN_TRIAL_NUMBER;
import static racingcar.global.enums.ExceptionMessage.TRIAL_MINIMUM_MESSAGE;

public class Trial {

    private final int trial;

    public Trial(int trial) {
        validateTrial(trial);
        this.trial = trial;
    }

    public int get() {
        return trial;
    }

    private void validateTrial(final int trial) {
        if (trial < MIN_TRIAL_NUMBER.getConstant()) {
            throw new IllegalArgumentException(TRIAL_MINIMUM_MESSAGE.getMessage());
        }
    }

}
