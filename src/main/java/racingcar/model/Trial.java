package racingcar.model;

import racingcar.utils.Validation;

public class Trial {
    private final int trial;

    public Trial(String trial) {
        Validation.validateTrial(trial);
        this.trial = Integer.parseInt(trial);
    }

    public Boolean compare(int value) {
        return value < trial;
    }

}
