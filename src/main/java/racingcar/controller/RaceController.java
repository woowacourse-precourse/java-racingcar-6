package racingcar.controller;

import racingcar.view.InputView;

public class RaceController {

    InputView inputView = new InputView();

    public void race(){
        start();
    }

    private void start(){
        inputView.getCars();

    }
}
