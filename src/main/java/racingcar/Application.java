package racingcar;

import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.ConsoleView;
import racingcar.util.ConsoleWrapper;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ConsoleWrapper consoleWrapper = new ConsoleWrapper();
        ConsoleView consoleView = new ConsoleView(consoleWrapper);

        List<String> carNames = consoleView.getInputCarNames();
        List<Car> cars = Car.createCars(carNames);

        int numberOfAttempts = consoleView.readValidNumberOfAttempts();

        RacingGame racingGame = new RacingGame(cars);
        GameController gameController = new GameController(racingGame, consoleView);
        gameController.playGame(numberOfAttempts);
    }
}
