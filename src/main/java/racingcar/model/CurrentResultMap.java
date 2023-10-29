package racingcar.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultMap {
    private final Map<String, Integer> resultMap = new HashMap<>();

    public ResultMap(List<Car> racingCars){
        for (Car racingCar : racingCars) {
            resultMap.put(racingCar.getName(), racingCar.getMoveDistance());
        }
    }

    public Map<String, Integer> getResultMap() {
        return resultMap;
    }
}
