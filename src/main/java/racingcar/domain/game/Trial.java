package racingcar.domain.game;


import static racingcar.global.enums.ExceptionMessage.TRIAL_MINIMUM_MESSAGE;

public class Trial {

    private static final int MIN_NUMBER = 1;
    private final int trial;

    public Trial(int trial) {
        validateTrial(trial);
        this.trial = trial;
    }

    public int get() {
        return trial;
    }

    private void validateTrial(final int trial) {
        if (trial < MIN_NUMBER) {
            throw new IllegalArgumentException(TRIAL_MINIMUM_MESSAGE.getMessage());
        }
    }


}
