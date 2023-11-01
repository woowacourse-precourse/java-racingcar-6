package racingcar.game;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;

public class GameResult {
    private final List<Car> cars;

    public GameResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }
}
