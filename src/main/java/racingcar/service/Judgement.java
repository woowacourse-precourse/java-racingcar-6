package racingcar.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Judgement {

    private Judgement() {
    }

    public static List<String> choseWinner(Map<String, Integer> position) {
        int winnerPosition = calculatePosition(position);
        return position.keySet().stream()
                .filter(name -> isWinner(position.get(name), winnerPosition))
                .collect(Collectors.toList());
    }

    private static Integer calculatePosition(Map<String, Integer> position) {
        return position.values().stream()
                .max(Integer::compare)
                .orElse(0);
    }

    private static boolean isWinner(int racerPosition, int winnerPosition) {
        return racerPosition == winnerPosition;
    }
}
