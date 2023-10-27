package racingcar.model;

import racingcar.controller.Validation;

public class Rounds {
    private final Validation validation;
    private final Car car;

    public Rounds() {
        this.validation = new Validation();
        this.car = new Car();
    }

    public int getRounds(String input) {
        validation.checkRoundsNumeric(input);
        int rounds = Integer.parseInt(input);
        validation.checkRoundsZero(rounds);
        return rounds;
    }
}
