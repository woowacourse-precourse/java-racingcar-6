package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.RandomGenerator;

public class RacingGame {

    private List<Car> cars;
    private RandomGenerator randomGenerator;

    public RacingGame(List<String> carNames, RandomGenerator randomGenerator) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.randomGenerator = randomGenerator;
    }

    public void race() {
        for (Car car : cars) {
            int randomValue = randomGenerator.pick();
            car.move(randomValue);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}
