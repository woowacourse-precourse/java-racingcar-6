package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
public class RaceResult {
    public static List<Car> getWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
