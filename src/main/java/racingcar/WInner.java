package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;

public class WInner {
    public Dictionary<String, Integer> compare(ArrayList<Integer> lastGameResult, ArrayList<String> carList) {
        int maxScore = Collections.max(lastGameResult);

        Dictionary<String, Integer> winners = new Hashtable<>();

        for (int i = 0; i < carList.size(); i++) {
            if (lastGameResult.get(i) >= maxScore) {
                winners.put(carList.get(i), lastGameResult.get(i));
            }
        }
    return winners;
    }
}
