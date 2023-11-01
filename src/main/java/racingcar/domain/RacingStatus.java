package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import net.bytebuddy.dynamic.scaffold.MethodGraph.Linked;

public class RacingStatus {
    public LinkedHashMap<String, Integer> racingMoveCount() {
        RacingValue racingValue = new RacingValue();
        ForwardCarCondition forwardCarCondition = new ForwardCarCondition();
        PrintRacingRankStatus printRacingRankStatus = new PrintRacingRankStatus();


        int raceCount = racingValue.racingCount;
        System.out.println();
        System.out.println("실행 결과");
        LinkedHashMap<String, Integer> result = racingValue.racingStatus;
        for (int i = 0; raceCount > i; i++) {
            result = forwardCarCondition.racingCarCount();
            printRacingRankStatus.printRacingCar(result);
            System.out.println();
        }
        return result;
    }


}
