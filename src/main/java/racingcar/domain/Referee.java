package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Referee {
    public String callWinnerCar() {
        Racing racing = new Racing();
        Map<String, Integer> racingResult = racing.racingMoveCount();
        return "최종 우승자 : " + String.join(", ", winnerCar(racingResult));
    }

    public List<String> winnerCar(Map<String, Integer> racingResult) {
        List<String> winnerCar = new ArrayList<>();
        int racingResultMax = Collections.max(racingResult.values());
        for (String key : racingResult.keySet()) {
            if (racingResult.get(key) == racingResultMax) {
                winnerCar.add(key);
            }
        }
        return winnerCar;
    }
}
