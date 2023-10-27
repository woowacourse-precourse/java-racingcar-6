package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.CarService;

public class Application {
    public static void main(String[] args) {
        CarService carService = new CarService();
        RacingController racingController = new RacingController(carService);
        racingController.init();
    }
}
