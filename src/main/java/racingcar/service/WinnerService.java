package racingcar.service;

import racingcar.vo.Car;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerService {
    public List<Car> findWinners(List<Car> cars) {
        int maxTotalForwards = getMaxTotalForwards(cars);
        return cars.stream()
                .filter(car -> car.getTotalForward() == maxTotalForwards)
                .collect(Collectors.toList());
    }

    private int getMaxTotalForwards(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getTotalForward)
                .max()
                .orElse(0);
    }
}
