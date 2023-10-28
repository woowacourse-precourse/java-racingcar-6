package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    private InputView inputView;

    private OutputView outputView;

    public void run() {
        RacingCar racingCar = inputView.inputCarName();
        Integer movement = inputView.inputMovement();
    }
}
