package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {

    Cars cars;
    List<String> raceResult = new ArrayList<>();

    public void start(Cars cars, TryCount tryCount) {
        this.cars = cars;

        Result result = new Result(cars);

        for (int j = 0; j < tryCount.getTryCount(); j++) {
            round();
            result.printRaceResult(raceResult);
        }
    }

    private void round() {
        CarController carController = new CarController();

        for (Car car : cars.getCars()) {
            raceResult.add(carController.moveOrStop(car));
        }
    }
}
