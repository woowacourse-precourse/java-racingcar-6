package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Referee {
    public String callWinnerCar() {
        RacingStatus racingStatus = new RacingStatus();
        Map<String, Integer> racingResult = racingStatus.racingMoveCount();
        return "최종 우승자 : " + String.join(", ", winnerCarSelect(racingResult));
    }

    public List<String> winnerCarSelect(Map<String, Integer> racingResult) {
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
