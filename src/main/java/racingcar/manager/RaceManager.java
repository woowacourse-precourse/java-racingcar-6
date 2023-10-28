package racingcar.manager;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RaceResult;

public class RaceManager {


    public RaceManager() {
    }

    public RaceResult playRound(List<Car> cars) {
        List<Car> movedCars = new ArrayList<>();
        for (Car car : cars) {
            movedCars.add(car.attemptMove());
        }
        return new RaceResult(movedCars);
    }

}
