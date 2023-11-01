package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void driveAll() {
        cars.forEach(Car::drive);
    }

    public List<String> getWinnersName() {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getTotalDistance() == getMaxDistance()) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxDistance() {
        return Collections.max(getTotalDistances());
    }

    public List<Integer> getTotalDistances() {
        return cars.stream().map(Car::getTotalDistance).collect(Collectors.toList());
    }

    public List<String> getNames() {
        return cars.stream().map(Car::getName).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        List<String> carsString = cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
        return String.join("\n", carsString);
    }
}
