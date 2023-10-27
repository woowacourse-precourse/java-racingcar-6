package racingcar.controller;

import racingcar.view.InputView;

public class RacingCarController {
    InputView inputView = new InputView();

    public void run() {
        System.out.println(inputView.carName());
        System.out.println(inputView.playNumber());
    }
}
