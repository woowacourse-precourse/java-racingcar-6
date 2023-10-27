package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class GameService {
    /**
     * 우승 자동차 배열 반환
     */
    public List<String> getWinnerCars(List<Car> cars) {
        List<String> carNames;
        int maxDistance = findMaxDistance(cars);
        carNames = cars.stream()
                .filter(car -> car.getDistance() == maxDistance).map(Car::getName)
                .collect(Collectors.toList());
        return carNames;
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
