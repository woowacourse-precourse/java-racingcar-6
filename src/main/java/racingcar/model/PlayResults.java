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
            PlayResult result = new PlayResult(car);
            results.add(result);
        }
        return results;
    }
}
