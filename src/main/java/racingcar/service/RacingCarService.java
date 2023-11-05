package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarService {
    public Cars createCars(String[] strArr) {
        return new Cars(strArr);
    }

    public void moveCars(Cars cars) {
        cars.getCars()
                .forEach(Car::move);
    }

    public List<String> getWinnerCarNames(Cars cars) {
        var maxDistance = maxCarsDistance(cars);

        return cars.getCars()
                .stream()
                .filter(car ->
                        car.getDistance() == maxDistance)
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
