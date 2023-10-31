package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarService {
    private final CarsFactory carsFactory;

    public RacingCarService() {
        carsFactory = new CarsFactory();
    }

    public Cars createCars(String[] strArr) {
        return carsFactory.createCars(strArr);
    }


    public void moveCars(Cars cars) {
        cars.getCars()
                .forEach(Car::move);
    }

    public List<String> getWinnerCarNames(Cars cars) {
        return cars.getCars()
                .stream()
                .filter(car ->
                        car.getDistance() == maxCarsDistance(cars))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int maxCarsDistance(Cars cars) {
        return cars.getCars()
                .stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }
}
