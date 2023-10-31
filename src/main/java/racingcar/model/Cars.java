package racingcar.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {
    private static final Map<String, Integer> carsData = new HashMap<>();
    private static final int START_LINE = 0;

    public Map<String, Integer> setCarsData(List<String> joinCarsName) {
        for (String s : joinCarsName) {
            carsData.put(s, START_LINE);
        }
        return carsData;
    }

    public Map<String, Integer> getCarsData() {
        return carsData;
    }
}
