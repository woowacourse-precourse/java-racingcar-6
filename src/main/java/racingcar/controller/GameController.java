package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;

import java.util.List;

public class GameController {
    Cars racingCars;
    public GameController() {
        initializeGame();
    }

    public void initializeGame() {
        racingCars = new Cars(InputView.requestRacingCarNames());
    }
}
