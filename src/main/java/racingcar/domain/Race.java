package racingcar.domain;

import java.util.List;

public class Race {
    private final List<Car> cars;
    private final Integer round;

    public Race(List<Car> cars, Integer round) {
        this.cars = cars;
        this.round = round;
    }

    public void start() {
        for (int i = 0; i < round; i++) {
            for (Car car : cars) {
                Integer randomNumber = RandomNumberGenerator.generate();
                if (randomNumber >= 4) {
                    car.forward();
                }
            }
        }
    }
}
