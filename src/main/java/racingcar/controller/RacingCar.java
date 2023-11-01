package racingcar.controller;

import racingcar.view.RacingCarView;

public class RacingCar {
    private RacingCarView racingCarView;

    public RacingCar() {
        racingCarView = RacingCarView.getInstance();
    }

    public void start() {
        racingCarView.printInputCarNameMessage();
    }
}
