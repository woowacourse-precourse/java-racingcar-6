package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.service.UserService;
import racingcar.view.CarView;

import java.util.List;

public class CarController {

    private final CarService carService;
    private final UserService userService;
    private final CarView carView;

    public CarController(CarService carService, UserService userService, CarView carView) {
        this.carService = carService;
        this.userService = userService;
        this.carView = carView;
    }

    public void startRacing() {

        List<Car> cars = carService.createCars(userService.getCarNames());
        carService.startRacing(cars, userService.getMoveCount());
        carView.printWinner(cars);

    }
}
