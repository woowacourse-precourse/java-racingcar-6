package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.RandomGenerator;

public class Race {
    private final List<Car> cars;
    private final int tries;

    public Race(List<Car> cars, int tries) {
        this.cars = cars;
        this.tries = tries;
    }

    public void start() {
        for (int i = 0; i < tries; i++) {
            for (Car car : cars) {
                car.move(RandomGenerator.generateRandomNumber());
            }
        }
    }
    
}
