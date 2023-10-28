package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Referee {
    private final Map<String, Integer> moveCountMap;
    private int maxMoveCount;

    public Referee(Map<String, Integer> moveCountMap) {
        this.moveCountMap = new LinkedHashMap<>(moveCountMap);
        setMaxMoveCount();
    }

    private void setMaxMoveCount() {
        OptionalInt maxOptional = moveCountMap.values()
                .stream()
                .mapToInt(Integer::intValue)
                .max();
        maxMoveCount = maxOptional.orElse(0);
    }

    public List<String> getWinnerList() {
        return moveCountMap.entrySet()
                .stream()
                .filter(e -> e.getValue() == maxMoveCount)
                .map(Entry::getKey)
                .collect(Collectors.toList());
    }
}
