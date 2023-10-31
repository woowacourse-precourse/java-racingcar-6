package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;

public class GameController {
    Cars racingCars;

    public GameController() {
        initializeGame();
    }

    public void initializeGame() {
        racingCars = new Cars(InputView.requestRacingCarNames());
    }
}
