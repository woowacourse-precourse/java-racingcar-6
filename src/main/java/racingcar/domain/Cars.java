package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomNumberGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Cars simulateNextRound(RandomNumberGenerator generator) {
        return new Cars(
                cars.stream()
                        .map(car -> car.move(generator.getRandomNumber()))
                        .collect(Collectors.toList())
        );
    }
}
