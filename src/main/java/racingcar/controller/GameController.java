package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final List<Car> cars;

    private GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.cars = new ArrayList<>();
    }

    public static GameController makeGame(InputView inputView, OutputView outputView) {
        return new GameController(inputView, outputView);
    }

    public void playGame() {
        startGame();
        findWinner();
    }

    private void startGame() {
        createCars();
        int attempts = readAttemptsNumber();
        startRacing(attempts);
    }

    private void createCars() {
        outputView.printStartGame();
        List<String> carNames = inputView.inputCarNames();

        for (String carName : carNames) {
            cars.add(Car.makeCar(carName));
        }
    }

    private int readAttemptsNumber() {
        outputView.printAskAttemptsNumber();
        return inputView.inputAttemptsNumber();
    }

    private void startRacing(int attempts) {
        outputView.printRacingStatus();
        while (attempts > 0) {
            moveCars();
            outputView.printCarPositions(cars);
            attempts--;
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public void findWinner() {
        Winner winner = Winner.createWinner(cars);
        List<String> winners = winner.findWinners();
        outputView.printRacingResult(winners);
    }

}
