package racingcar.domain;

import java.util.Collections;
import java.util.Map;

public class Winner {
    public static int maxForward(Map<String, Integer> cars) {
        return Collections.max(cars.values());
    }

    public static String[] winnerList(Map<String, Integer> cars, int maxForwardCount) {
        return cars.entrySet().stream()
                .filter(car -> car.getValue() == maxForwardCount)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }
}
