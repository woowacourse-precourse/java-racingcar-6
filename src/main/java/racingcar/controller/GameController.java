package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.RoundNumber;
import racingcar.view.InputView;

public class GameController {
    Cars racingCars;
    RoundNumber roundNumber;

    public GameController() {
        initializeGame();
    }

    public void initializeGame() {
        racingCars = new Cars(InputView.requestRacingCarNames());
        roundNumber = new RoundNumber(InputView.requestRepetitionNumber());
    }

    public void startGame() {

    }
}
