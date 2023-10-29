package racingcar.core;

import racingcar.domain.Car;

import java.util.List;

public class Game {
    public List<Car> progress(List<Car> cars) {
        for (Car car : cars) {
            car.tryMove();
        }
        return cars;
    }
}
