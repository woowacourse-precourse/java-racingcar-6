package racingcar.domain;

import java.util.Map;

public class GetWinner {

    public static String winner(Map<String, Integer> result) {
        StringBuilder winner = new StringBuilder();
        int maxNum = getMaxNum(result);
        int count = 0;
        for (String name : result.keySet()) {
            if (result.get(name) != maxNum) {
                continue;
            }
            if (count > 0) {
                winner.append(", ");
            }
            winner.append(name);
            count++;
        }
        return winner.toString();
    }

    public static int getMaxNum(Map<String, Integer> result) {
        int maxNum = 0;
        for (Integer value : result.values()) {
            if (value > maxNum) {
                maxNum = value;
            }
        }
        return maxNum;
    }
}
