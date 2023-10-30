package racingcar.domain;

import racingcar.domain.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private List<Car> cars;

    public List<Car> findWinnerCars() {
        Car carWithMaxDistance = getCarWithMaxDistance();
        return cars.stream()
                .filter(car -> car.isCarWithMaxDistance(carWithMaxDistance))
                .collect(Collectors.toList());
    }

    private Car getCarWithMaxDistance() {
        Car maxDistanceCar = cars.get(0);
        for (Car car : cars) {
            if (car.isEqualOrGreaterThan(maxDistanceCar)) {
                maxDistanceCar = car;
            }
        }
        return maxDistanceCar;
    }
}