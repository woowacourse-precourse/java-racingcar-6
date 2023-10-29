package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarCreator {
    public static Cars createCars() {
        return new Cars(createCarList());
    }

    private static List<Car> createCarList() {
        List<String> names = CarNames.splitName();
        return names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
