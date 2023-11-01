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
        cars = createPlayerCars();
        runRacing(askPlayerMovingTryCount(), cars);
        OutputView.printGameRoundResultMessage(cars.getWinnerNameList());
    }

    public Cars createPlayerCars() {
        OutputView.printInputCarNameMessage();
        return gameManager.createCars(inputView.getCarsName());
    }

    public int askPlayerMovingTryCount() {
        OutputView.printInputMovingTryCountMessage();
        return inputView.getMovingTryCount();
    }

    public void runRacing(int round, Cars cars) {
        OutputView.printGameRoundResultMessage();
        for (int i = 0; i < round; i++) {
            cars.runCars();
            OutputView.printInfomation(cars.toString());
        }
    }
}