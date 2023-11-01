package racingcar.domain;

import java.util.LinkedHashMap;

public class RacingStatus {
    public LinkedHashMap<String, Integer> racingMoveCount() {
        ForwardCarCondition forwardCarCondition = new ForwardCarCondition();
        RacingRankStatus printRacingRankStatus = new RacingRankStatus();

        int raceCount = RacingValue.racingCount;
        System.out.println();
        System.out.println("실행 결과");
        LinkedHashMap<String, Integer> result = RacingValue.racingStatus;
        for (int i = 0; raceCount > i; i++) {
            result = forwardCarCondition.racingCarCount();
            printRacingRankStatus.printRacingCar(result);
            System.out.println();
        }
        return result;
    }


}
