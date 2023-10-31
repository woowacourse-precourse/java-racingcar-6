package racingcar.domain;

import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Winner {
    static List<String> candidates;
    static int maxScore = 0;

    public static String findWinner(Hashtable<String, Integer> sb) {
        candidates = Collections.list(sb.keys());   // 공동 0점 시 전원 우승

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
