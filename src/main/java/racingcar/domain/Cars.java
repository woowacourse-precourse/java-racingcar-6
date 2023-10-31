package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

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
                winners.add(car.toString());
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
        List<Integer> totalDistances = cars.stream()
                .map(Car::getTotalDistance)
                .collect(Collectors.toList());
        return totalDistances;
    }

    public List<String> getNames() {
        List<String> names = cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
        return names;
    }

    public int getNumberOfCar() {
        return cars.size();
    }
}
