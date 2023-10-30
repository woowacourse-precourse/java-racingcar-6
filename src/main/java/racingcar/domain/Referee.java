package racingcar.domain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    public List<String> checkResult(Cars cars) {
        Collection<Car> carList = cars.getCars();
        Car maxDistanceCar = findMaxDistanceCar(carList);

        return findWinnersCarName(carList, maxDistanceCar);
    }

    private Car findMaxDistanceCar(Collection<Car> carList) {
        return carList.stream()
                .max(Car::compareTo)
                .orElse(null);
    }

    private List<String> findWinnersCarName(Collection<Car> carList, Car maxPositionCar) {
        return carList.stream()
                .filter(maxPositionCar::hasSameDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
