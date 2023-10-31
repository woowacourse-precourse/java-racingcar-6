package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.RandomNumberGenerator;

public class RacingService {
    private static final int FORWARD_THRESHOLD = 4;
    private final List<Car> cars;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingService(List<Car> cars) {
        this.cars = cars;
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    private void playRacing() {
        for (Car car : cars) {
            if (canMoveForward()) {
                car.moveForward();
            }
        }
    }

    private boolean canMoveForward() {
        return randomNumberGenerator.createRandomNumber() >= FORWARD_THRESHOLD;
    }

}
