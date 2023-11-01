package racingcar;

import racingcar.controller.CarController;
import racingcar.service.CarService;
import racingcar.service.UserService;
import racingcar.view.CarView;

public class Application {
    public static void main(String[] args) {

        CarView carView = new CarView();
        CarService carService = new CarService(carView);
        UserService userService = new UserService();
        CarController carController = new CarController(carService, userService, carView);
        carController.startRacing();
    }
}
