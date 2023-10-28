package racingcar.service;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class GameService {
    /**
     * 우승 자동차 배열 반환
     */
    public List<String> getWinnerCars(List<Car> cars) {
        int maxDistance = findMaxDistance(cars);
        return filterWinnerCars(cars, maxDistance);
    }

    /**
     * 최대로 움직인 자동차 탐색
     */
    private List<String> filterWinnerCars(List<Car> cars, int maxDistance) {
        return cars.stream()
                .filter(car -> car.isMaxDistance(maxDistance))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    /**
     * 최대로 움직인 횟수 탐색
     */
    private int findMaxDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .getAsInt();
    }
}
