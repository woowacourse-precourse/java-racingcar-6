package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    public static List<String> findMostProgressCar(List<Car> carList) {
        int maxProgressCount = carList.stream()
                .mapToInt(Car::getProgressCount)
                .max()
                .orElse(0);

        List<String> mostProgressCarsName = carList.stream()
                .filter(car -> car.getProgressCount() == maxProgressCount)
                .map(Car::getName)
                .collect(Collectors.toList());

        return mostProgressCarsName;
    }
}
