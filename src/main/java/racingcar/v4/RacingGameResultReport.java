package racingcar.v4;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingGameResultReport {
    public void printResultTitle() {
        System.out.println("실행 결과");
    }

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
        System.out.println();
    }

    public void announceWinners(Map<String, Integer> racingStateMap) {
        int maxDistance = Collections.max(racingStateMap.values());

        List<String> winners = racingStateMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxDistance)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("최종 우승자: " + String.join(", ", winners));
    }
}
