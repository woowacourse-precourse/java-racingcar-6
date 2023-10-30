package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Winner {
    public static int maxForward(Map<String, Integer> cars) {
        return Collections.max(cars.values());
    }

    public static List<String> winnerList(Map<String, Integer> cars, int maxForward) {
        return cars.entrySet().stream()
                .filter(entry -> entry.getValue() == maxForward)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
