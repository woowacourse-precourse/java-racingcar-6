package racingcar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacePreparation {

    public Map<String, StringBuilder> makeScoreBoard(List<String> carNames) {
        Map<String, StringBuilder> scoreBoard = new LinkedHashMap<>();

        for (String name : carNames) {
            scoreBoard.put(name, new StringBuilder());
        }
        return scoreBoard;
    }
}
