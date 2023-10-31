package racingcar.controller;

import racingcar.domain.CarController;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.domain.Referee;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameController {

    private final CarFactory carFactory;

    private final CarController carController;

    private final Referee referee;

    private Cars cars;

    public GameController() {
        carFactory = new CarFactory();
        carController = new CarController();
        referee = new Referee();
    }

    public void play() {
        setConfiguration();
        startRacing();
        showWinner();
    }

    public void setConfiguration() {
        cars = carFactory.produceCars(Input.inputCarName());
        carController.setStatus(cars, Input.inputMoveChance());
    }

    public void startRacing() {
        while (carController.checkMoveChance()) {
            carController.moveCars();

            cars.getCarList()
                    .forEach(car -> Output.carStatusMessage(car.getName(), car.getMoveStatus()));
            System.out.println();
        }
    }

    public void showWinner() {
        Output.winnerMessage(referee.findWinner(cars));
    }
}
