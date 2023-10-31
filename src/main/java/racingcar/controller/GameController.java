package racingcar.controller;

import racingcar.model.CarList;
import racingcar.model.RoundNumber;
import racingcar.view.InputView;

public class GameController {
    CarList carList;
    RoundNumber roundNumber;

    public GameController() {
        initializeGame();
        startGame();
    }

    public void initializeGame() {
        carList = new CarList(InputView.requestRacingCarNames());
        roundNumber = new RoundNumber(InputView.requestRepetitionNumber());
    }

    public void startGame() {
        carList.raceOneRound(carList);
    }
}
