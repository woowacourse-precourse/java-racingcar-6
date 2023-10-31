package racingcar.domain.racing;

import java.util.List;
import racingcar.domain.car.Car;

public class GameRoundManager {
    private final List<Car> cars;

    public GameRoundManager(List<Car> cars) {
        this.cars = cars;
    }

    public void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }
}