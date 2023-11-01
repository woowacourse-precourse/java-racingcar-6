package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerDecider {

    public List<String> getWinners(List<Car> carList) {
        return compareDistance(carList);
    }

    private List<String> compareDistance(List<Car> carList) {
        int maxDistance = getMaxDistance(carList);
        return getMaxDistanceCar(maxDistance, carList);
    }

    private int getMaxDistance(List<Car> carList) {
        return carList.stream().mapToInt(Car::getDistance).max().orElse(0);
    }

    private List<String> getMaxDistanceCar(int maxDistance, List<Car> carList) {
        return carList.stream().filter(car -> car.getDistance() == maxDistance).map(Car::getName)
            .collect(Collectors.toList());
    }
}
