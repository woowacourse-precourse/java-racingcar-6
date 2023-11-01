package racingcar.domain;

import java.util.List;
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
}
