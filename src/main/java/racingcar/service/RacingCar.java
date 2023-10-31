package racingcar.service;

import java.util.List;
import racingcar.domain.Car;

public class RacingCar {
    private final Car[] cars;
    private final int tryCount;

    public RacingCar(List<String> carNames, int tryCount) {
        this.tryCount = tryCount;
        this.cars = new Car[carNames.size()];
        for (int i = 0; i < carNames.size(); i++) {
            cars[i] = new Car(carNames.get(i));
        }
    }

    public void start() {
        for (int i = 0; i< tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
    }
}
