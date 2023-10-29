package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import racingcar.utils.randomNum;

public class startRacing {

    public void checkRandomNum(HashMap<String, Integer> carNameHashMap) {
        randomNum randomNum = new randomNum();
        Set<String> keySet = carNameHashMap.keySet();

        for (String key : keySet) {
            int randNum = randomNum.makeRandomNum();
            if (randNum >= 4) {
                carNameHashMap.put(key, carNameHashMap.get(key) + 1);
            }
        }
    }

    public void racingResult(HashMap<String, Integer> carNameHashMap) {
        Set<String> keySet = carNameHashMap.keySet();
        for (String key : keySet) {
            int value = carNameHashMap.get(key);
            System.out.print(key + " : ");
            for (int j = 0; j < value; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public Integer whoIsWinner(HashMap<String, Integer> carNameHashMap) {
        int maxValue = 0;
        for (Map.Entry<String, Integer> entry : carNameHashMap.entrySet()) {
            int value = entry.getValue();
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public List<String> isAJointWinner(HashMap<String, Integer> carNameHashMap) {
        int winnerPoint = whoIsWinner(carNameHashMap);
        List<String> maxKey = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : carNameHashMap.entrySet()) {
            int value = entry.getValue();
            if (value == winnerPoint) {
                maxKey.add(entry.getKey());
            }
        }
        return maxKey;
    }

    public String realWinner(HashMap<String, Integer> carNameHashMap) {
        List<String> maxKey = isAJointWinner(carNameHashMap);
        String winner = "";
        if (!maxKey.isEmpty()) {
            winner = String.join(", ", maxKey);
        }
        return winner;
    }
}
