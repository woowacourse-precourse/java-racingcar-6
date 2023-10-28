package racingcar.game;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;
import racingcar.utils.randomGenerator.RandomNumberGenerator;

public class RacingCarGame {

    private List<Car> cars;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingCarGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void play(List<String> carNames, int attemptCount) {
        makeCars(carNames);
        for (int round = 0; round < attemptCount; round++) {
            moveCarsForward();
        }
    }

    private void moveCarsForward() {
        for (Car car : cars) {
            int randomNumber = randomNumberGenerator.generateRandomSingleDigit();
            if (randomNumber>=4) {
                car.move();
            }
        }
    }

    private void makeCars(List<String> carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.of(carName));
        }
    }

}
