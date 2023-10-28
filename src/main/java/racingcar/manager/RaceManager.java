package racingcar.manager;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RaceResult;

public class RaceManager {


    public RaceManager() {
    }

    public RaceResult playRound(List<Car> cars) {
        for (Car car : cars) {
            car.attemptMove();
        }
        return new RaceResult(cars);
    }

}
