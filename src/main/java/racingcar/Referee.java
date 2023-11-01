package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Referee {
    public List<String> find_maxKeys(LinkedHashMap<String, Integer> map) {

        List<String> maxKeys = new ArrayList<>();
        int maxValue = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value > maxValue) {
                maxValue = value;
                maxKeys.clear();
                maxKeys.add(entry.getKey());
            } else if (value == maxValue) {
                maxKeys.add(entry.getKey());
            }
        }
        return maxKeys;
    }

    public void show(LinkedHashMap<String, Integer> map) {
        List<String> members = find_maxKeys(map);
        String result = String.join(",", members);
        System.out.print("최종 우승자 : ");
        System.out.println(result);
    }
}
