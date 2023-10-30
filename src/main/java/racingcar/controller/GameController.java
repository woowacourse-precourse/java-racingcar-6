package racingcar.controller;

import racingcar.domain.CarController;
import racingcar.domain.CarFactory;
import racingcar.domain.CarManager;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameController {

    private CarFactory carFactory;

    private CarController carController;

    private CarManager carManager;

    public void play() {
        setConfiguration();
        startRacing();
        showWinner();
    }

    public void setConfiguration() {
        carFactory = new CarFactory(Input.inputCarName());
        carFactory.produceCars();

        carController = new CarController(carFactory.getCarList(), Input.inputMoveChance());
        carManager = new CarManager(carFactory.getCarList());
    }

    public void startRacing() {
        while (carController.checkChance()) {
            carController.moveCars();

            carFactory.getCarList()
                    .forEach(car -> Output.carStatusMessage(car.getName(), car.getMoveStatus()));
            System.out.println();
        }
    }

    public void showWinner() {
        Output.winnerMessage(carManager.findWinner());
    }
}
