package racingcar.model.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.model.generator.MovementGenerator;
import racingcar.model.record.MoveCount;

public class Race {
    private Cars cars;
    private MoveCount moveCount;

    public Race(Cars cars, MoveCount moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

    public List<Map<String, Integer>> startMove(MovementGenerator movementGenerator) {
        List<Map<String, Integer>> results = new ArrayList<>();
        for (int times = 0; times < moveCount.moveCount(); times++) {
            cars.moveCars(movementGenerator);
            results.add(new HashMap<>(cars.getRankingTable()));
        }
        return results;
    }

    public List<String> determineWinners() {
        Map<String, Integer> rankingTable = cars.getRankingTable();

        int maxPosition = Collections.max(rankingTable.values());
        List<String> winners = rankingTable.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxPosition)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return winners;
    }
}
