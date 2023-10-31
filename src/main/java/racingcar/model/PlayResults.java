package racingcar.model;

import racingcar.enums.CarType;

import java.util.ArrayList;
import java.util.List;

public class PlayResults {
    private final Cars cars;
    private final List<PlayResult> results = new ArrayList<>();

    public PlayResults(Cars cars) {
        this.cars = cars;
    }

    public List<PlayResult> getResults() {
        for(Car car : cars.getCarList()) {
            PlayResult result = new PlayResult();
            result.put(CarType.CAR_NAME, car.getName());
            result.put(CarType.DISTANCE, car.getDistance());
            results.add(result);
        }
        return results;
    }
}
