package racingcar.domain;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void attemptToMoveAll() {
        for (Car car : cars) {
            car.attemptToMove();
        }
    }

    public Map<String, Integer> getRoundInfo() {
        return cars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getPosition));
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .map(Car::getPosition)
                .orElse(0);
    }
}
