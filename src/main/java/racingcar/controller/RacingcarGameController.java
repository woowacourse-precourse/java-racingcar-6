package racingcar.controller;

import racingcar.RacingcarGame;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingcarGameController {
    InputView inputView;
    OutputView outputView;
    RacingcarGame racingcarGame;

    public RacingcarGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.racingcarGame = new RacingcarGame();
    }

    public void start() {
        inputView.readInputCarNameMessage();
        String[] carsName = inputView.getCarsName();
        racingcarGame.setCars(carsName);
    }
}
