package racingcar.domain;

import racingcar.domain.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private List<Car> cars;

    private Race() {

    }

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void moveEachCar() {
        cars.forEach(Car::move);
    }

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

    public String getStatusString() {
        return cars.stream()
                .map(Car::getMovementString)
                .collect(Collectors.joining("\n")) + "\n";
    }

    public String getWinnerString() {
        return findWinnerCars().stream()
                .map(Car::getNameString)
                .collect(Collectors.joining(", "));
    }
}