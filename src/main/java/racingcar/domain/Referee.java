package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Referee {

    public Referee() {
    }

    public List<String> findWinners(Map<String, Integer> raceResult) {
        int maxValue = Collections.max(raceResult.values());
        // Map 데이터 중 value가 max인 key값 반환
        return raceResult.entrySet().stream()
                .filter(entry -> entry.getValue() == maxValue)
                .map(Map.Entry::getKey)
                .toList();
    }

    public void announceWinner(List<String> winners) {
        // 최종 우승자 출력
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
