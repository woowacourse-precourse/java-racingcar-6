package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.RunCount;
import racingcar.view.Input;

public class RacingController {

    public void startRace() {
        Cars cars = new Cars(Input.inputCarNames());
        RunCount runCount = new RunCount(Input.inputRunCount());

        for (int i = 0; i < runCount.getCount(); i++) {
            cars.run();
        }

    }
}
