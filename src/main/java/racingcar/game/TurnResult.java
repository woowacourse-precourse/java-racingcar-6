package racingcar.game;

import java.util.List;
import java.util.Map;

public class TurnResult {
    private final Map<String, Integer> racerPosition;

    public TurnResult(Map<String, Integer> racerPosition) {
        this.racerPosition = racerPosition;
    }

    public int getPosition(String racerName) {
        return racerPosition.get(racerName);
    }

    public List<String> getAllRacerNames() {
        return racerPosition.keySet().stream().toList();
    }

    @Override
    public String toString() {
        return racerPosition.toString();
    }
}
