package service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RaceWinnerAnalyzer {
    public static List<String> determineWinner(Map<String, Integer> carList) {
        int maxDistance = carList.values().stream()
                .max(Integer::compareTo)
                .orElse(0);

        return carList.entrySet().stream()
                .filter(entry -> entry.getValue() == maxDistance)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
