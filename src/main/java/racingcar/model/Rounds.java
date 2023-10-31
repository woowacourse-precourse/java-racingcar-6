package racingcar.model;

import racingcar.controller.Validation;

public class Rounds { // 전진 시도 횟수(라운드수) 관련 클래스

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
