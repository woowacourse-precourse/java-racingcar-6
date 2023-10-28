package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class GameController {
    List<String> names;
    int epoch ;
    public GameController() {

    }
    public void run() {
        names = IOController.showStartMessage();
        epoch = IOController.showEpochMessage();
        Cars cars = startRace();
        endRace(cars);
    }

    private void endRace(Cars cars) {
        Integer topPosition = cars.getTopPosition();
        IOController.showWinnerName(cars.getWinnerNames(topPosition));
    }

    private Cars startRace() {
        Cars cars = Cars.buildCars(names);
        for(int i = 0 ; i < epoch;i++) {
            cars.moveAll();
            IOController.showRoundResult(cars);
        }
        return cars;
    }

}
