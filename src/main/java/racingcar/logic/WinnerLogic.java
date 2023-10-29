package racingcar.logic;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinnerLogic {
    public List<String> finalWinner(Map<String, Integer> players) {
        int winnerScore = players.values()
                .stream()
                .max(Integer::compareTo)
                .orElse(0);

        List<String> winners = players.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == winnerScore)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return winners;
    }
}
