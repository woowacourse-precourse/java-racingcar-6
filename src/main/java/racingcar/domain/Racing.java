package racingcar.domain;

import java.util.Map;

public class Racing {
    public void racingMoveCount() {
        RacingCount racingCount = new RacingCount();
        Car car = new Car();

        int raceCount = racingCount.inputRacingCount();
        Map<String, Integer> result = null;
        for (int i=0; raceCount>i; i++) {
            result = car.racingCarCount();
        }
        System.out.println("result : " + result);
    }
}
