package racingcar.model;

import java.util.*;

public class RacingResult {
    private Map<String, Integer> result;
    private static int INITIAL_DISTANCE = 0;

    public RacingResult(CarNames carNames, TryCount tryCount) {
        result = new HashMap<>();

        for (String carName : carNames.getCarNames()) {
            result.put(carName, INITIAL_DISTANCE);
        }
    }

    public void moveForward(String carName) {
        result.put(carName, result.get(carName).intValue() + 1);
    }

    public Map<String, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
    public Set<String> getNames() {
        return result.keySet();
    }

    public List<String> getWinners() {
        int maxDistance = Collections.max(result.values());
        Set<String> carNames = result.keySet();

        return carNames.stream()
                .filter(carName -> result.get(carName) == maxDistance)
                .toList();
    }
}
