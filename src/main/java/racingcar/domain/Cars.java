package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> carList) {
        this.cars = carList;
    }

    public void race(Strategy strategy) {
        cars.stream().forEach(car -> car.move(strategy));
    }

    public Position findMaxPosition() {
        Position maxPosition = cars.stream()
                .map(Car::getPosition)
                .max(Comparator.comparing(Position::getDistance))
                .orElseThrow(() -> new NoSuchElementException());
        return maxPosition;
    }

    public List<String> findWinners() {
        List<String> Winners = cars.stream()
                .filter(car -> car.getPosition().equals(findMaxPosition()))
                .map(Car::getCarName)
                .collect(Collectors.toList());
        return Winners;
    }

    public List<Car> getCars() {
        return cars;
    }
}
