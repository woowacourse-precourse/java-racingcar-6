package racingcar;

import racingcar.controller.CarController;
import racingcar.service.CarService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarService carService = new CarService();
        CarController carController = new CarController(carService);
        carController.startRacingGame();
    }
}
