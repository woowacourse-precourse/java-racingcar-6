package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;

    public Race(List<String> carNames) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void raceRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
