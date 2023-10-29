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

        OutputValue.getNamesMessage();

        String[] result = InputValue.getRacingCarsNames();

        racingCars.setCars(result);

        OutputValue.getRangeMessage();

        int result2 = InputValue.getRacingRange();


        for(Car car : racingCars.getCars()) {
            System.out.print(car.getName() + " ");
        }

        System.out.println(result2);
    }

    private void gameStart() {

    }

    private void gameEnd() {

    }

}
