package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.GameManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    InputView inputView = new InputView();
    GameManager gameManager = new GameManager();
    Cars cars;

    public void gameStart() {
        OutputView.printInputCarNameMessage();
        cars = gameManager.createCars(inputView.getCarsName());
        OutputView.printInputMovingTryCountMessage();
        runRacing(inputView.getMovingTryCount(), cars);
        OutputView.printGameRoundResultMessage(gameManager.getWinnerNameList(cars.getMaxMoveInCars(), cars));
    }

    public void runRacing(int round, Cars cars) {
        OutputView.printGameRoundResultMessage();
        for (int i = 0; i < round; i++) {
            gameManager.runRound(cars);
            OutputView.printInfomation(cars.toString());
        }
    }
}