package racingcar.domain;

import racingcar.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    private static final int PROCEED_CONDITION = 4;
    private final List<Car> cars = new ArrayList<>();
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void addCar(String name) {
        cars.add(new Car(name));
    }

    public void startTurn() {
        for (Car car : cars) {
            int randomNumber = randomNumberGenerator.getRandomNumber();
            if (randomNumber >= PROCEED_CONDITION) {
                car.proceed();
            }
        }
    }
}
