package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.RunCount;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingController {

    public void startRace() {
        Cars cars = new Cars(Input.inputCarNames());
        RunCount runCount = new RunCount(Input.inputRunCount());

        runRace(cars, runCount);
        endRace(cars);
    }

    private void runRace(Cars cars, RunCount runCount) {
        Output.printRunResultNotice();
        for (int i = 0; i < runCount.getCount(); i++) {
            cars.run();
        }
    }

    private void endRace(Cars cars) {
        cars.handleWinnerResult();
    }
}
