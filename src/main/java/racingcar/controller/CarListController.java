package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarListController {

    public Cars createCars(List<String> carNames) {
        return new Cars(createCarList(carNames));
    }

    private List<Car> createCarList(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
