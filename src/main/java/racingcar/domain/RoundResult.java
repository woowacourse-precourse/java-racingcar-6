package racingcar.domain;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record RoundResult(Map<Name, Distance> results) {
    public RoundResult(Map<Name, Distance> results) {
        this.results = new HashMap<>(results);
    }

    @Override
    public Map<Name, Distance> results() {
        return new HashMap<>(results);
    }

    public List<Name> getWinners() {
        Distance maxDistance = getMaxDistance();

        return results.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maxDistance))
                .map(Map.Entry::getKey)
                .toList();
    }

    private Distance getMaxDistance() {
        return results.values().stream()
                .max(Comparator.comparingInt(Distance::value))
                .orElseThrow(() -> new IllegalArgumentException("최대 거리를 찾을 수 없습니다."));
    }
}
