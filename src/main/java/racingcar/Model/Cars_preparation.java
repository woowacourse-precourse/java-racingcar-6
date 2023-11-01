package racingcar.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import racingcar.Model.Car;

public class Cars_preparation {
    private final Map<Car, Integer> carAndPositionMap;

    public Cars_preparation(Map<Car, Integer> carAndPositionMap) {
        this.carAndPositionMap = carAndPositionMap;
    }

    public Set<Entry<Car, Integer>> entrySet() {
        return carAndPositionMap.entrySet();
    }

    public List<String> getWinners(int leadCarNumber) {
        List<String> win_person = new ArrayList<>();
        for (Entry<Car, Integer> entry : carAndPositionMap.entrySet()) {
            if (entry.getValue() == leadCarNumber) {
                win_person.add(entry.getKey().toString());
            }
        }
        return win_person;
    }
}
