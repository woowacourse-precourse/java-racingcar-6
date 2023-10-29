package racingcar.controller;

import racingcar.model.RacingCup;

public class RacingCupController {
    private RacingCup racingCup;
    public RacingCupController(int totalRounds) {
        this.racingCup = new RacingCup(totalRounds);
    }

}
