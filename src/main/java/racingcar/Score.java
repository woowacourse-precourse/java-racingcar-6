package racingcar;

import java.util.HashMap;
import java.util.Map;

public class Score {

    Map<String, Integer> movingDistance = new HashMap<>();

    public Score(Map<String, Integer> movingDistance) {
        this.movingDistance = movingDistance;
    }
}
