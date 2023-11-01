package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomNumberGenerator;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<String> carNames) {
        cars = new ArrayList<>();
        carNames.forEach(carName -> cars.add(new Car(carName)));
    }

    public void moveOrStop() {
        cars.forEach(car -> car.move(RandomNumberGenerator.generate()));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> findWinner() {
        return cars.stream()
                .filter(car -> car.getPosition() == findMaxPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
