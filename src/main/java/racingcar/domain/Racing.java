package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Racing {
    private HashMap<String, Integer> score;

    public Racing(HashMap<String, Integer> score) {
        this.score = score;
    }

    public HashMap<String, Integer> getScore() {
        return score;
    }

    public List<String> findWinners() {
        if(score.isEmpty()) {
            throw new IllegalArgumentException("게임이 진행되지 않았습니다.");
        }
        Integer maxScore = Collections.max(score.values());

        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : score.entrySet()) {
            if (entry.getValue().equals(maxScore)) {
                winners.add(entry.getKey());
            }
        }

        return winners;
    }
}