package racingcar;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RaceOfficial {
    public List<Car> findWinners(List<Car> cars, int longestDistance) {
        return cars.stream()
                .filter(car -> car.getDistance() == longestDistance)
                .collect(Collectors.toList());
    }

    public int findLongestDistance(List<Car> cars) {
        return (int) cars.stream()
                .map(Car::getDistance)
                .min(Comparator.reverseOrder())
                .orElse(0);
    }
}