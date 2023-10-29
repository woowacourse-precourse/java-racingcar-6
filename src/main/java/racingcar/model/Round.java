package racingcar.model;

import racingcar.exception.round.NonPositiveIntegerException;

public class Round {
    private final int totalNumberOfRounds;
    private int currentRoundNumber;

    public Round(int totalNumberOfRounds) {
        validateCount(totalNumberOfRounds);
        this.totalNumberOfRounds = totalNumberOfRounds;
        currentRoundNumber = 1;
    }

    public boolean Over() {
        return currentRoundNumber == totalNumberOfRounds;
    }

    public void plusOne() {
        currentRoundNumber++;
    }

    void validateCount(int totalNumberOfRounds) {
        if(totalNumberOfRounds < 0) {
            throw new NonPositiveIntegerException();
        }
    }

}
