package racingcar.domain;

import java.util.Map;

public class RacingStatus {
    public Map<String, Integer> racingMoveCount() {
        InputRacingCount racingCount = new InputRacingCount();
        ForwardCarCondition car = new ForwardCarCondition();
        PrintRacingRankStatus printRankStatus = new PrintRacingRankStatus();

        int raceCount = racingCount.inputRacingCount();
        System.out.println();
        System.out.println("실행 결과");
        Map<String, Integer> result = null;
        for (int i = 0; raceCount > i; i++) {
            result = car.racingCarCount();
            printRankStatus.printRacingCar(result);
            System.out.println();
        }
        return result;
    }


}
