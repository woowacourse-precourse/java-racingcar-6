package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.view.InputValue;
import racingcar.view.OutputValue;

public class GameController {

    private RacingCars racingCars = new RacingCars();

    public GameController() {
        gameInit();
        gameStart();
        gameEnd();
    };

    private void gameInit() {

        OutputValue.startMessage();

        String[] result = InputValue.getRacingCars();

        racingCars.setCars(result);

        for(Car car : racingCars.getCars()) {
            System.out.print(car.getName() + " ");
        }
    }

    private void gameStart() {

    }

    private void gameEnd() {

    }

}
