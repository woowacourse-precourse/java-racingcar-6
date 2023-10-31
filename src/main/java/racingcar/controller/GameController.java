package racingcar.controller;

import racingcar.domain.CarController;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.domain.Referee;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameController {

    private final CarController carController;

    private final Cars cars;

    public GameController() {
        carController = new CarController();
        cars = new Cars();
    }

    public void play() {
        setConfiguration();
        startRacing();
        showWinner();
    }

    public void setConfiguration() {
        cars.setStatus(CarFactory.produceCars(Input.inputCarName()));
        carController.setStatus(cars, Input.inputMoveChance());
    }

    public void startRacing() {
        while (carController.checkMoveChance()) {
            carController.moveCars();
            Output.carStatusMessage(cars.getCarList());
        }
    }

    public void showWinner() {
        Output.winnerMessage(Referee.findWinner(cars));
    }
}
