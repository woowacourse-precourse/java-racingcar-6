package racingcar.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class WinnerSelector {
    HashMap<String, Integer> winnerMap = new HashMap<String, Integer>();

    public ArrayList<String> select(ArrayList<Car> candidateList) {
        HashMap<String, Integer> winnerMap = convertListToMap(candidateList);
        winnerMap = retainKeyWithMaxValue(winnerMap);

        return new ArrayList<String>(winnerMap.keySet());
    }

    public HashMap<String, Integer> convertListToMap(ArrayList<Car> candidateList) {
        for (Car candidate : candidateList) {
            winnerMap.put(candidate.getCarName(), candidate.getLocation());
        }

        return winnerMap;
    }

    public HashMap<String, Integer> retainKeyWithMaxValue(HashMap<String, Integer> hashMap) {
        int maxValue = Collections.max(hashMap.values());

        Iterator<Entry<String, Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue() < maxValue) {
                iterator.remove();
            }
        }

        return hashMap;
    }

}
