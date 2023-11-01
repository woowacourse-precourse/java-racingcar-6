package racingcar.domain;

import java.util.List;

public class Game {
    public List<Integer> movingCars(List<Integer> scores) {
        final Engine engine = new Engine();
        for (int carIdx = 0; carIdx < scores.size(); carIdx++) {
            boolean result = engine.isMovingForward();
            if (result) {
                int beforeScore = scores.get(carIdx);
                scores.set(carIdx, beforeScore + 1);
            }
        }
        return scores;
    }
    
}
