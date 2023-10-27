package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.view.InputView;

public class RaceController {

    InputView inputView = new InputView();

    public void race(){
        start();
    }

    private void start(){
        RacingCar racingCar = new RacingCar();
        racingCar.updateCars(inputView.getCars());
        racingCar.updateRaceCount(inputView.getRaceCount());


    }
}
