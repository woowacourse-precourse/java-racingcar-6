package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Winner;
import racingcar.util.GameResultMaker;
import racingcar.util.RacingGameManager;
import racingcar.view.OutputView;
import racingcar.view.InputView;

import java.util.List;

public class RacingGame {

    private RacingGameManager gameManager;
    private GameResultMaker gameResultMaker;
    private OutputView outputView;

    public RacingGame(RacingGameManager gameManager, GameResultMaker gameResultMaker, OutputView outputView) {
        this.gameManager = gameManager;
        this.gameResultMaker = gameResultMaker;
        this.outputView = outputView;
    }

    public void start() {
        List<Car> cars = getCarList();
        int count = getCount();
        outputView.printConsole();
        do {
            printGameResult(cars);
        } while (count-- > 1);
        printGameWinner(cars);
    }

    private List<Car> getCarList() {
        String userInput = InputView.getCarNamesFromPlayerInput();
        return gameManager.createCarListFromPlayerInput(userInput);
    }

    private int getCount() {
        String countInput = InputView.getCountFromPlayerInput();
        return gameManager.createCountFromPlayerInput(countInput);
    }

    private void printGameResult(List<Car> cars) {
        gameResultMaker.makeGameResult(cars);
        outputView.printGameResult(cars);
    }

    private void printGameWinner(List<Car> cars) {
        Winner winner = new Winner(cars);
        List<String> gameWinners = winner.getWinners();
        outputView.printGameWinner(gameWinners);
    }
}