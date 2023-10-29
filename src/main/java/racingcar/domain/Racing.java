package racingcar.domain;

import java.util.Map;

public class Racing {
    public Map<String, Integer> racingMoveCount() {
        RacingCount racingCount = new RacingCount();
        Car car = new Car();

        int raceCount = racingCount.inputRacingCount();
        Map<String, Integer> result = null;
        for (int i=0; raceCount>i; i++) {
            result = car.racingCarCount();
        }
        return result;
    }
}
