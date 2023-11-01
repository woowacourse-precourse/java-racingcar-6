package racingcar.model;

import java.util.HashMap;
import java.util.Map;

public class RacingResult {
    Map<Name, Distance> racingResult;

    public RacingResult() {
        this.racingResult = new HashMap<>();
    }

    public Map<Name, Distance> getRacingResult() {
        return racingResult;
    }

    public void updateRacingResult(Map<Name, Distance> racingResult) {
        this.racingResult = racingResult;
    }
}
