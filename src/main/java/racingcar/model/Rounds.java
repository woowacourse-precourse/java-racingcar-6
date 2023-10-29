package racingcar.model;

import racingcar.controller.Validation;

public class Rounds {

    private final Validation validation;

    public Rounds() {
        this.validation = new Validation();
    }

    public Integer getRounds(String input) {
        validation.checkRoundsNumeric(input);
        int rounds = Integer.parseInt(input);
        validation.checkRoundsZeroOrNegative(rounds);
        return rounds;
    }
}
