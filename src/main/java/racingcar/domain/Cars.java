package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;
    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void playRound() {
        this.cars.forEach(Car::playRound);
    }

    public List<Car> getWinners() {
        int maxDistance = cars.stream()
                .mapToInt(car -> car.getDistance())
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getDistance()==maxDistance)
                .collect(Collectors.toList());
    }
}
