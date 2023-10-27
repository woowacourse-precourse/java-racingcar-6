package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void race(){
        start();
    }

    private void start(){
        RacingCar racingCar = new RacingCar();
        racingCar.updateCars(inputView.getCars());
        racingCar.updateRaceCount(inputView.getRaceCount());

        outputView.printRaceResult();

    }
}
