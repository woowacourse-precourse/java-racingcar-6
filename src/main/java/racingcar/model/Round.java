package racingcar.model;

import racingcar.exception.round.NonPositiveIntegerException;
import racingcar.validator.model.ModelValidator;
import racingcar.validator.model.RoundValidator;

public class Round {
    private final int totalNumberOfRounds;
    private int currentRoundNumber;

    public Round(int totalNumberOfRounds) {
        this.totalNumberOfRounds = totalNumberOfRounds;
        currentRoundNumber = 1;

        RoundValidator.getInstance().validate(this);
    }

    public int getTotalNumberOfRounds() {
        return totalNumberOfRounds;
    }

    public boolean over() {
        return currentRoundNumber > totalNumberOfRounds;
    }

    public void plusOne() {
        currentRoundNumber++;
    }



}
