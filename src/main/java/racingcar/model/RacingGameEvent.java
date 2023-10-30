package racingcar.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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


    public void startEvent(int attempt) {
        for (int i = 0; i < attempt; i++) {
            for (Entry<Car, List<Integer>> value : positionHistory.entrySet()) {
                Car carName = value.getKey();
                List<Integer> position = value.getValue();
                position.add(carName.moveForward(new MoveForward().success()));
            }
        }
    }
}
