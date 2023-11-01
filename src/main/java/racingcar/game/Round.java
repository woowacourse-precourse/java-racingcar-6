package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validation;

public class Round {
    private final int round;

    public Round(String input) {
        this.round = Validation.validateGameRound(input);
    }

    public int getRound() {
        return round;
    }
}
