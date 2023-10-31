package racingcar.domain;

import racingcar.validator.RaceRoundInputValidator;
import racingcar.validator.InputValidator;

public class RaceRound {

    private int rounds;
    private InputValidator validator = new RaceRoundInputValidator();

    public RaceRound(String stringRound) {
        validator.validateInput(stringRound);
        int round = Integer.parseInt(stringRound);
        rounds = round;
    }

    public int getRounds() {
        return rounds;
    }
}
