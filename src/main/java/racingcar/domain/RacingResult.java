package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingResult {

    public int findMaximumDistance(Map<String, Integer> records) {
        List<Integer> sortedDistances = records.values().stream().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());

        return sortedDistances.get(0);
    }

    public List<String> findWinners(int maximumDistance, Map<String, Integer> records) {
        List<String> winners = new ArrayList<>();

        for (String car : records.keySet()) {
            if(maximumDistance == records.get(car)) {
                winners.add(car);
            }
        }

        return winners;
    }
}
