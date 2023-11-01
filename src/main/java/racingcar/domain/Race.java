package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.ErrorMessage;
import racingcar.constant.Number;

public class Race {
    private final int totalTrials;
    private int currentTrials;

    public Race(String trialNumber) {
        validate(trialNumber);
        this.totalTrials = Integer.parseInt(trialNumber);
        this.currentTrials = Number.INITIAL_TRIAL_NUMBER;
    }

    public static int pickRandomNumber() {
        return Randoms.pickNumberInRange(Number.RANDOM_MIN_NUMBER, Number.RANDOM_MAX_NUMBER);
    }

    public void increaseCurrentTrial() {
        this.currentTrials++;
    }

    public boolean currentTrialReachedTotal() {
        return this.totalTrials == this.currentTrials;
    }

    public void validate(String trialNumber) {
        checkTrialNumberIsEmpty(trialNumber);
        checkTrialNumberIsNumber(trialNumber);
        checkTrialNumberIsNonNegative(trialNumber);
    }

    public void checkTrialNumberIsNumber(String trialNumber) {
        try {
            Integer.parseInt(trialNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRIALNUMBER_IS_NOT_NUMBER_MESSAGE);
        }
    }

    public void checkTrialNumberIsNonNegative(String trialNumber) {
        if (Integer.parseInt(trialNumber) < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRIALNUMBER_IS_NOT_NUMBER_MESSAGE);
        }
    }

    public void checkTrialNumberIsEmpty(String trialNumber) {
        if (trialNumber == null || trialNumber.replace(" ", "").isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRIALNUMBER_IS_NOT_NUMBER_MESSAGE);
        }
    }
}
