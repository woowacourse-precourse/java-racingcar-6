package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomGenerator;

public class Cars {

    private final int MIN_RANGE_NUM = 0;
    private final int MAX_RANGE_NUM = 9;

    final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveAllCars() {
        RandomGenerator randomGenerator = new RandomGenerator();
        for (Car car : cars) {
            int randomNumber = randomGenerator.createRandomNumber(MIN_RANGE_NUM, MAX_RANGE_NUM);
            car.move(randomNumber);
        }
    }

    public List<String> findWinners() {
        return cars.stream()
            .filter(car -> car.getPosition() == findMaxPosition())
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    public int findMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(-1);
    }
}
