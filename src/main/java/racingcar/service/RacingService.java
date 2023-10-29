package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingService {
    public List<Car> createCarList(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.createCar(carName));
        }
        return cars;
    }
}
