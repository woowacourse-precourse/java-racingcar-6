package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsFactory {
    public Cars createCars(String[] carsName) {
        List<Car> cars = Arrays.stream(carsName)
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(cars);
    }
}
