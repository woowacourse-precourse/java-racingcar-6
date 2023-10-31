package racingcar.domain;

import java.util.*;

public class Winner {
    static List<String> candidates;
    static int maxScore = 0;

    public static String findWinner(LinkedHashMap<String, Integer> sb) {
        candidates = new ArrayList<>(sb.keySet());   // 공동 0점 시 전원 우승

        for(Map.Entry<String, Integer> entry : sb.entrySet()) {
            if(entry.getValue() > maxScore) {
                candidates.clear();
                candidates.add(entry.getKey());
                maxScore = entry.getValue();
            }
            else if(entry.getValue() == maxScore) {
                candidates.add(entry.getKey());
            }
        }

        return printWinner(candidates);
    }

    public static String printWinner(List<String> winners) {
        return "최종 우승자 : " + String.join(", ", winners);
    }
}
