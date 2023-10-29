package racingcar.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.domain.Car;

public class Cars {
    public static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new).toList();
    }

    public String selectionWinners(List<Car> carList) {
        Car candidate = calculateMaxDistance(carList);
        return findOtherWinners(candidate, carList).toString();
    }

    private Car calculateMaxDistance(List<Car> carList) {
        List<Car> sortedCar = new ArrayList<>(carList);
        Collections.sort(sortedCar);
        return sortedCar.get(0);
    }

    private StringBuilder findOtherWinners(Car candidate, List<Car> carList) {
        return candidate.isEqualDistance(carList);
    }
}
