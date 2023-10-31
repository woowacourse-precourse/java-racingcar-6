package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.RacingCarView;

public class RacingCarController {

    private final RacingCarView racingCarView;

    public RacingCarController(RacingCarView racingCarView) {
        this.racingCarView = racingCarView;
    }

    public void play(){
        Cars cars = new Cars();
        String carNames = racingCarView.promptForNames();
        cars.setNames(carNames);
    }


}
