package racingcar;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RaceOfficial {
    public int findLongestDistance(List<Car> cars) {
        return (int) cars.stream()
                .map(Car::getDistance)
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .orElse(0);
    }

    public List<Car> findWinners(List<Car> cars) {
        int longestDistance = findLongestDistance(cars);

        return cars.stream()
                .filter(car -> car.getDistance() == longestDistance)
                .collect(Collectors.toList());
    }
}