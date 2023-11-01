package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerChecker {

    public List<String> checkWinner(List<Car> carList) {
        if (carList == null || carList.isEmpty())
            throw new IllegalArgumentException("Empty List");

        int maxDistance = carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow();

        return carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}