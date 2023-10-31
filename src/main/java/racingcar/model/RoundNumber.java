package racingcar.model;

import racingcar.validator.RoundNumberValidation;

public class RoundNumber {
    int roundNumber;

    public RoundNumber(String roundNumber) {
        RoundNumberValidation validator = new RoundNumberValidation(roundNumber);
    }
}
