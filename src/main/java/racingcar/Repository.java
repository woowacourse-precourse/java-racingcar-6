package racingcar;

import racingcar.domain.Car;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private int id = 1;
    private Map<Integer, Car> cars = new HashMap<>();

    public void add(Car car) {
        cars.put(id, car);
        id++;
    }

    public List<Car> returnAll() {
        return new ArrayList<>(cars.values());
    }
}
