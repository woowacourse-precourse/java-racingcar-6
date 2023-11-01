package racingcar.repository;

import racingcar.entity.Car;

import java.util.HashMap;
import java.util.Map;

public class CarRepository {

    Map<String, Car> carMap = new HashMap<String,Car>();
    public Car save(Car saveCar) {
        carMap.put(saveCar.getName(), saveCar);
        return saveCar;
    }

    public Car findByName(String name) {
        return carMap.get(name);
    }



}
