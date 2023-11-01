package racingcar.model;

import java.util.*;

public class CarRankingCalculator {

    public String rankingCheck(LinkedHashMap<String, String> carAndDistance) {

        String longestValue = "";
        String winner = "";
        ArrayList<String> winners = new ArrayList<>();

        for (String key : carAndDistance.keySet()) {
            if (carAndDistance.get(key).length() > longestValue.length()) {
                longestValue = carAndDistance.get(key);
                winner = key;
            }
        }

        for(String key : carAndDistance.keySet()) {
            if(carAndDistance.get(key).length() == carAndDistance.get(winner).length()) {
                winners.add(key);
            }
        }

        if(winners.size() == 1) {
            return winner;
        }else {
            return String.join(",", winners);
        }
    }
}
