package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class PlayResults {
    private final List<PlayResult> results = new ArrayList<>();

    public PlayResults(Cars cars) {
        for(Car car : cars.getCarList()) {
            PlayResult result = new PlayResult(car);
            results.add(result);
        }
    }

    public List<PlayResult> getResults() {
        return results;
    }
}
