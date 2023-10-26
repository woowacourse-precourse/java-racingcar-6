package racingcar.controller;

import racingcar.view.InputView;
import racingcar.service.Exception;

public class GameController {
    public void play() {
        setCar();
    }

    private void setCar() {
        Exception.checkCarName(InputView.InputCarName());
    }
}
