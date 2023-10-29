package racingcar.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void move() {
        for (Car car : cars) {
            car.moveIfSatisfy();
        }
    }

    public Map<String, Integer> getMoveCountMap() {
        Map<String, Integer> moveCountMap = new LinkedHashMap<>();
        cars.forEach(car -> moveCountMap.put(car.getName(), car.getMoveCount()));
        return moveCountMap;
    }
}
