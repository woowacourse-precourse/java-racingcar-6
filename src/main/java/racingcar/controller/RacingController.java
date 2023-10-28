package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.view.InputView;

public class RacingController {
    private Race race;

    public void run() {
        String carNames = InputView.getInputCarName();
        String count = InputView.getInputCount();
        this.race = new Race(carNames, count);
        race.printResults();
    }
}
