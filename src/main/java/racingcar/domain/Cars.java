package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    List<Car> cars;

    public Cars(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            Car car = new Car(carNames.get(i));
            cars.add(car);
        }
    }

    public void move(int gameCount) {
        for (int j = 0; j < gameCount; j++) {
            moveEachCar();
        }
    }

    private void moveEachCar() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (int i = 0; i < cars.size(); i++) {
            int randomNumber = randomNumberGenerator.generateNumber();
            Car car = cars.get(i);
            moveIfGreaterThanThree(car, randomNumber);
        }
    }

    private void moveIfGreaterThanThree(Car car, int randomNumber) {
        if (randomNumber > 3) {
            car.move();
        }
    }
}
