package racingcar;

import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.ConsoleView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        List<String> carNames = consoleView.getInputCarNames();
        List<Car> cars = Car.createCars(carNames);
        int numberOfAttempts = consoleView.readValidNumberOfAttempts();
        consoleView.printMessage("");

        RacingGame racingGame = new RacingGame(cars);
        GameController gameController = new GameController(racingGame, consoleView);
        gameController.playGame(numberOfAttempts);
    }
}