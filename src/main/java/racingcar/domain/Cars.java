package racingcar.domain;

import java.util.List;
import racingcar.service.RandomNumberGenerator;
import racingcar.service.Rule;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars, String[] carNames) {
        for (String car : carNames) {
            cars.add(new Car(car));
        }
        this.cars = cars;
    }

    public void moveCars(Rule rule, RandomNumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            int randomNumber = randomNumberGenerator.generateRandomNumber();
            car.move(rule, randomNumber);
        }
    }
}
