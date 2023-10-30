package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.service.UserService;

import java.util.List;

public class CarController {

    public void startRacing() {
        String carNames = UserService.getCarNames();
        List<Car> cars = CarService.createCars(carNames);
        int moveCount = UserService.getMoveCount();
        CarService.startRacing(cars, moveCount);

    }
}
