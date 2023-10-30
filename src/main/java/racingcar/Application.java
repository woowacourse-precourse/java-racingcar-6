package racingcar;

import racingcar.controller.RaceController;
import racingcar.model.CarFactory;
import racingcar.model.CarList;
import racingcar.model.Race;

public class Application {
    public static void main(String[] args) {
        CarList carList = new CarList();
        Race race = new Race(carList);
        CarFactory carFactory = new CarFactory(carList);
        RaceController raceController = new RaceController(carFactory, carList, race);
        raceController.createRace();
    }
}
