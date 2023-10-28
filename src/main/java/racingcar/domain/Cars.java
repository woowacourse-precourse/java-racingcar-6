package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

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

    public void printCar(int index) {
        System.out.println(cars.get(index));
    }

    public int size() {
        return cars.size();
    }

    public Map<String,Integer> getMoveCountMap() {
        Map<String,Integer> moveCountMap = new HashMap<>();
        cars.forEach(car -> moveCountMap.put(car.getName(), car.getMoveCount()));
        return moveCountMap;
    }
}
