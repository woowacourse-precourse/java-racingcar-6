package racingcar.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class JudgeResult {
    public static List<String> getWinners(List<Car> cars) {
        int maxDistance = getMaxDistance(cars);
        List<String> winners = cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
        return winners;
    }

    private static int getMaxDistance(List<Car> cars) {
        Car maxCar = Collections.max(cars);
        return maxCar.getDistance();
    }
}
