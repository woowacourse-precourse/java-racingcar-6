package racingcar;

import java.util.List;
import racingcar.domain.Car;

public class RacingGame {
    private List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void racing() {
        for (Car car : cars) {
            if (Racing.isMovingForward()) {
                car.addPosition();
            }
        }
    }
}
