package racingcar.domain;

import racingcar.domain.car.Car;

import java.util.List;

public class Race {

    private List<Car> cars;

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