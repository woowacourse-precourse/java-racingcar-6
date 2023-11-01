package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Referee {
    public String callWinnerCar() {
        RacingStatus racingStatus = new RacingStatus();
        LinkedHashMap<String, Integer> racingResult = racingStatus.racingMoveCount();
        return "최종 우승자 : " + String.join(", ", winnerCarSelect(racingResult));
    }

    public List<String> winnerCarSelect(LinkedHashMap<String, Integer> racingResult) {
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
