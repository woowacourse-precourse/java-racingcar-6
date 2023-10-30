package racingcar.service;

import racingcar.model.Car;
import racingcar.model.CarFactory;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private final List<Car> cars = new ArrayList<>();

    public void initCars(List<String> carNames) {
        cars.addAll(CarFactory.initCars(carNames));
    }
}
