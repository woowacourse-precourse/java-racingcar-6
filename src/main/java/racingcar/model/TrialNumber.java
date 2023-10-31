package racingcar.model;

import racingcar.utils.validators.TrialNumberValidator;

public class TrialNumber {
    private final int trialNumber;

    public TrialNumber(String trialNumber) {
        TrialNumberValidator.validateTrialNumber(trialNumber);
        this.trialNumber = Integer.parseInt(trialNumber);
    }

    public int getTrialNumber() {
        return trialNumber;
    }
}