package racingcar.domain;

import java.util.*;

public class Winner {
    public static String findWinner(LinkedHashMap<String, Integer> sb) {
        List<String> candidates = new ArrayList<>();
        int maxScore = 0;

        for (Map.Entry<String, Integer> entry : sb.entrySet()) {
            if (entry.getValue() > maxScore) {
                candidates.clear();
                candidates.add(entry.getKey());
                maxScore = entry.getValue();
            } else if (entry.getValue() == maxScore) {
                candidates.add(entry.getKey());
            }
        }

        return printWinner(candidates);
    }

    public static String printWinner(List<String> winners) {
        return "최종 우승자 : " + String.join(", ", winners);
    }
}
