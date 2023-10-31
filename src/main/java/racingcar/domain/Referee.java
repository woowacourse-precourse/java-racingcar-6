package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Referee {

    public List<String> winner(Map<String, Integer> raceResult) {

        List<String> winnerNames = new ArrayList<String>();
        int max = (Collections.max(raceResult.values()));
        for (Map.Entry<String, Integer> m : raceResult.entrySet()) {
            if (m.getValue() == max) {
                winnerNames.add(m.getKey());
            }
        }
        return winnerNames;
    }
}
