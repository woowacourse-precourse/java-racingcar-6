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

    public RacingGame(RacingGameManager gameManager, GameResultMaker gameResultMaker) {
        this.gameManager = gameManager;
        this.gameResultMaker = gameResultMaker;
    }

    public void start() {
        List<Car> cars = getCarList();
        int remainingRace = getRaceCount();
        OutputView.printConsole();
        do {
            printGameResult(cars);
        } while (remainingRace-- > 1);
        printGameWinner(cars);
    }

    private List<Car> getCarList() {
        String userInput = InputView.getCarNamesFromPlayerInput();
        return gameManager.createCarListFromPlayerInput(userInput);
    }

    private int getRaceCount() {
        String countInput = InputView.getRaceCountFromPlayerInput();
        return gameManager.createCountFromPlayerInput(countInput);
    }

    private void printGameResult(List<Car> cars) {
        gameResultMaker.makeGameResult(cars);
        OutputView.printGameResult(cars);
    }

    private void printGameWinner(List<Car> cars) {
        Winner winner = new Winner(cars);
        List<String> gameWinners = winner.getWinners();
        OutputView.printGameWinner(gameWinners);
    }
}