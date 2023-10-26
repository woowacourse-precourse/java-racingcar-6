package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Judgment {

    public List<String> checkWinners(List<Car> cars) {

        Map<String, Integer> records = new HashMap<>();

        for (Car car : cars) {
            records.put(car.getName(), car.getForward().length());
        }

        return getWinners(records, findMaxForward(records));
    }

    private List<String> getWinners(Map<String, Integer> records, int maxForward) {
        return records.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(maxForward))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private int findMaxForward(Map<String, Integer> records) {
        int max = records.values().stream()
                .max(Integer::compareTo)
                .orElse(0);
        return max;
    }
}
