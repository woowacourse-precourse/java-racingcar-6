package racingcar.controller;

import racingcar.domain.CarController;
import racingcar.domain.CarFactory;
import racingcar.domain.CarManager;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameController {

    private final CarFactory carFactory;

    private CarController carController;

    private CarManager carManager;

    public GameController(){
        carFactory = new CarFactory();
    }

    public void play() {
        setConfiguration();
        startRacing();
        showWinner();
    }

    public void setConfiguration() {
        carFactory.produceCars(Input.inputCarName());
        carController = new CarController(carFactory, Input.inputMoveChance());
        carManager = new CarManager(carFactory);
    }

    public void startRacing() {
        while (carController.checkMoveChance()) {
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
