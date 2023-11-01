package racingcar.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CheckWinner {

    public void winner(HashMap<String, Integer> raceResult) {
        int maxPoint = Collections.max(raceResult.values());

        System.out.print("최종 우승자 : ");
        System.out.println(
                raceResult.entrySet().stream().filter(m -> m.getValue() == maxPoint).map(Map.Entry::getKey).collect(
                        Collectors.joining(", ")));
    }
}
