package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void startRace() {
        for (Car car : cars) {
            car.move();
        }
    }

    public RaceResult calculateResult() {
        RaceResult result = new RaceResult();
        int maxPosition = getMaxPosition();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                result.addWinner(car.getName());
            }
        }
        return result;
    }

    private int getMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }
}
