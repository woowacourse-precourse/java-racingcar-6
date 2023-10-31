package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.Input;

public class RacingController {

    public void raceStart() {
        Cars cars = new Cars(Input.inputCarNames());
        TryCount tryCount = new TryCount(Input.inputTryCount());

//        for (int i = 0; i < tryCount; i++) {
//
//        }

    }
}
