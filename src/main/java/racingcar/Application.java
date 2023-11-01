package racingcar;

import racingcar.controller.FrontValidator;
import racingcar.controller.GameController;
import racingcar.controller.GameIOController;
import racingcar.controller.IOController;
import racingcar.controller.InputValidator;
import racingcar.model.vehicle.Cars;
import racingcar.model.vehicle.RacingCars;
import racingcar.view.ConsoleView;
import racingcar.view.IOView;

public class Application {
    public static void main(String[] args) {
        ConsoleView view = new IOView();
        FrontValidator frontValidator = new InputValidator();
        IOController ioController = new GameIOController(view, frontValidator);
        Cars cars = new RacingCars();
        GameController gameController = GameController.startGame(cars, ioController);
        gameController.processGame();
    }
}
