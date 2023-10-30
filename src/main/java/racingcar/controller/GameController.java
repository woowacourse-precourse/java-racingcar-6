package racingcar.controller;

import racingcar.domain.CarController;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameController {

    private final CarFactory carFactory;

    private final CarController carController;

    public GameController() {
        carFactory = new CarFactory();
        carController = new CarController();
    }

    public void play() {
        startRacing();
        showWinner();
    }

    public void startRacing() {
        Cars cars = carFactory.produceCars(Input.inputCarName());
        carController.setStatus(cars, Input.inputMoveChance());

        while (carController.checkMoveChance()) {
            carController.moveCars();

            cars.getCarList()
                    .forEach(car -> Output.carStatusMessage(car.getName(), car.getMoveStatus()));
            System.out.println();
        }
    }

    public void showWinner() {
        Output.winnerMessage(carController.findWinner());
    }
}
