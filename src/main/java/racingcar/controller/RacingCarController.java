package racingcar.controller;

import racingcar.view.InputView;

public class RacingCarController {
    final InputView inputView;

    public RacingCarController(InputView inputView){
        this.inputView = inputView;
    }

    public void run(){
        String cars = inputView.readRaceCarNames();
        String[] names = cars.split(",");
    }
}
