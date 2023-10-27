package racingcar.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RacingResult {

    private TryCount tryCount;
    private Map<String, Integer> result;
    private static int INITIAL_COUNT = 0;

    public void RacingResult(CarNames carNames, TryCount tryCount) {
        this.tryCount = tryCount;
        result = new HashMap<>();

        for (String carName : carNames.getCarNames()) {
            result.put(carName, INITIAL_COUNT);
        }

    }

    public Map<String, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }


}
