package racingcar;

import racingcar.controller.RaceController;
import racingcar.model.CarFactory;

public class Application {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        RaceController raceController = new RaceController(carFactory);
        raceController.playRacing();
    }
}
