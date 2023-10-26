package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.service.RandomNumberGenerator;
import racingcar.service.Rule;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] carNames) {
        cars = new ArrayList<>();
        for (String car : carNames) {
            cars.add(new Car(car));
        }
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public void moveCars(Rule rule, RandomNumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            int randomNumber = randomNumberGenerator.generateRandomNumber();
            car.move(rule, randomNumber);
        }
    }
}
