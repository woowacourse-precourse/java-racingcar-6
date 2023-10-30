package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.service.UserService;

import java.util.List;

public class CarController {

    public void startRacing() {

        List<Car> cars = CarService.createCars(UserService.getCarNames());
        CarService.startRacing(cars, UserService.getMoveCount());

    }
}
