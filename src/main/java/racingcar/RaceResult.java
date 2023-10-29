package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RaceResult {

    public int calculateForwardPoint(Map<String, StringBuilder> scoreResult) {

        return scoreResult.values().stream().mapToInt(StringBuilder::length).max().orElse(0);
    }

    public List<String> findWinners(int maxForwardPoint, Map<String, StringBuilder> scoreBoard) {
        List<String> winnerList = new ArrayList<>();

        scoreBoard.forEach((key, value) -> {
            if (value.length() == maxForwardPoint) {
                winnerList.add(key);
            }
        });
        return winnerList;
    }
}
