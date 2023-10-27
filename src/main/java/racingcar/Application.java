package racingcar;

import racingcar.controller.CarController;
import racingcar.controller.RaceController;

public class Application {
    public static void main(String[] args) {
        CarController carController = new CarController();
        RaceController raceController = new RaceController(carController.getCarList());
    }
}
