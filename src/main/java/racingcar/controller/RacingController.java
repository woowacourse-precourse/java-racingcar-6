package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.RunCount;
import racingcar.view.Input;

public class RacingController {

    public void startRace() {
        Cars cars = new Cars(Input.inputCarNames());
        RunCount runCount = new RunCount(Input.inputRunCount());

        runRace(cars, runCount);
        endRace();
    }

    private void runRace(Cars cars, RunCount runCount) {
        for (int i = 0; i < runCount.getCount(); i++) {
            cars.run();
        }
    }

    private void endRace() {

    }
}
