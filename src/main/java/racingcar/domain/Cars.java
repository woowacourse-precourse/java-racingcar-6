package racingcar.domain;

import java.util.ArrayList;
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

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getTotalDistance() == this.getMaxDistance()) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : this.cars) {
            maxDistance = Math.max(maxDistance, car.getTotalDistance());
        }
        return maxDistance;
    }

    public List<Integer> getTotalDistances() {
        return cars.stream().map(Car::getTotalDistance).collect(Collectors.toList());
    }

    public List<String> getNames() {
        return cars.stream().map(Car::getName).collect(Collectors.toList());
    }

    public List<String> getRoundResult() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
    }
}
