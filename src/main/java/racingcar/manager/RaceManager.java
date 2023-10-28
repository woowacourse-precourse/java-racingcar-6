package racingcar.manager;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.RaceResult;

public class RaceManager {

    private final List<Car> cars;
    // TODO : attemptCount의 책임을 고려할 것.
    private int attemptCount;

    public RaceManager(List<Car> cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public RaceResult playRound() {
        for (Car car : cars) {
            car.attemptMove();
        }
        attemptCount--;
        return new RaceResult(cars);
    }

}
