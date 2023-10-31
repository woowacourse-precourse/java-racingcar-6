package racingcar.domain;

import static racingcar.constants.RaceRule.MOVE_DISTANCE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RaceProgress {
    private Map<String, Integer> progress;

    public RaceProgress(List<String> carNames) {
        this.progress = new HashMap<>();
        init(carNames);
    }

    private void init(List<String> carNames) {
        for (String carName : carNames) {
            progress.put(carName, 0);
        }
    }

    public Set<String> getCarList() {
        return this.progress.keySet();
    }

    public void addMovedDistance(String carName) {
        Integer curDistance = progress.get(carName);
        progress.replace(carName, curDistance + MOVE_DISTANCE.getValue());
    }

    public int getMovedDistance(String carName) {
        return progress.get(carName);
    }

    public List<String> getWinners() {
        int longestDistance = getLongestDistance();
        return progress.entrySet().stream()
                .filter(entry -> entry.getValue() == longestDistance)
                .map(Entry::getKey)
                .toList();
    }

    private int getLongestDistance() {
        return progress.entrySet().stream()
                .map(Entry::getValue)
                .max(Integer::compareTo)
                .orElse(0);
    }
}
