package racingcar.domain;

import java.util.Map;

public class Racing {
    public Map<String, Integer> racingMoveCount() {
        RacingCount racingCount = new RacingCount();
        Car car = new Car();

        int raceCount = racingCount.inputRacingCount();
        System.out.println();
        System.out.println("실행 결과");
        Map<String, Integer> result = null;
        for (int i=0; raceCount>i; i++) {
            result = car.racingCarCount();
            result.forEach((key, value)->{
                System.out.print(key + " : ");
                for (int j = 0; value > j; j++) {
                    System.out.print("-");
                }
                System.out.println();
            });
            System.out.println();
        }
        return result;
    }
}
