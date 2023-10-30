package racingcar.model;

import java.util.List;

public class Judgment {

    public List<String> judge(List<Car> cars) {
        final int maxCnt = getMaxCnt(cars);
        final List<Car> maxCars = getMaxCars(cars, maxCnt);
        return maxCars.stream()
            .map(Car::getName)
            .toList();
    }

    private static int getMaxCnt(List<Car> cars) {
        return cars.stream()
            .mapToInt(Car::getMoveCount)
            .max()
            .orElseThrow();
    }

    private static List<Car> getMaxCars(List<Car> cars, int maxCnt) {
        return cars.stream()
            .filter(car -> car.getMoveCount() == maxCnt)
            .toList();
    }

}
