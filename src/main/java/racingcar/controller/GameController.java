package racingcar.controller;

import racingcar.domain.CarFactory;
import racingcar.domain.CarManager;
import racingcar.domain.Cars;
import racingcar.domain.Referee;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameController {

    private final CarManager carManager;

    private final Cars cars;

    public GameController() {
        carManager = new CarManager();
        cars = new Cars();
    }

    public void play() {
        setConfiguration();
        startRacing();
        showWinner();
    }

    public void setConfiguration() {
        cars.setStatus(CarFactory.produceCars(Input.inputCarName()));
        carManager.setStatus(cars, Input.inputMoveChance());
    }

    public void startRacing() {
        while (carManager.checkMoveChance()) {
            carManager.moveCars();
            Output.carStatusMessage(cars.getCarList());
        }
    }

    public void showWinner() {
        Output.winnerMessage(Referee.findWinner(cars));
    }
}
