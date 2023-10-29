package racingcar.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.vo.Car;

public class RacingGameEvent {

    private Map<Car, List<Integer>> positionHistory = new LinkedHashMap<>();

    public RacingGameEvent(String[] cars) {
        for (String carName : cars) {
            positionHistory.put(new Car(carName), new ArrayList<>());
        }
    }

    public Map<Car, List<Integer>> getPositionHistory() {
        return positionHistory;
    }
}
