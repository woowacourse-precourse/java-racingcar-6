package racingcar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Cars_preparation {
    private final Map<Car, Integer> carGoCountMap;

    public Cars_preparation(Map<Car, Integer> carGoCountMap) {
        this.carGoCountMap = carGoCountMap;
    }

    public Set<Entry<Car, Integer>> entrySet() {
        return carGoCountMap.entrySet();
    }

    public List<String> getWinners(int leadCarNumber) {
        List<String> win_person = new ArrayList<>();
        for (Entry<Car, Integer> entry : carGoCountMap.entrySet()) {
            if (entry.getValue() == leadCarNumber) {
                win_person.add(entry.getKey().toString());
            }
        }
        return win_person;
    }
}
