package racingcar.v4;

import java.util.Map;

public class RacingGameResultReport {
    public void printCarPositionWithName(Map<String, Integer> racingStateMap) {
        for (Map.Entry<String, Integer> entry : racingStateMap.entrySet()) {
            String carName = entry.getKey();
            int position = entry.getValue();
            System.out.print(carName + " : ");
            for (int i = 0; i < position; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
