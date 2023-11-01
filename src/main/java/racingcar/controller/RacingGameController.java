package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    InputView inputView;
    OutputView outputView;
    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart() {
        Cars cars = receiveCarNames();
        Game game = receiveTryCount();

        printGameResultTitle();
        while (!game.isGameEnd()) {
            cars.moveForwardByRandomNumber();
            printGameResult(cars);
        }

        printGameWinner(cars);
    }

    private Cars receiveCarNames() {
        return new Cars(inputView.getCarNames());
    }

    private Game receiveTryCount() {
        return new Game(inputView.getTryCount());
    }

    private void printGameResultTitle() {
        outputView.printEmptyLine();
        outputView.printGameResultTitle();
    }

    private void printGameResult(Cars cars) {
        for (Car car : cars.getCars()) {
            outputView.printGameResultProgressBar(car.getName(), car.getDistance());
        }
        outputView.printEmptyLine();
    }

    private void printGameWinner(Cars cars) {
        outputView.printGameWinnerName(cars.sendRacingGameWinner());
    }
}
