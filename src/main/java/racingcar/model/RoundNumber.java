package racingcar.model;

import racingcar.util.Utils;
import racingcar.validator.RoundNumberValidator;

public class RoundNumber {
    public final int roundNumber;

    public RoundNumber(String roundNumber) {
        new RoundNumberValidator(roundNumber);
        this.roundNumber = Utils.toInt(roundNumber);
    }
}
