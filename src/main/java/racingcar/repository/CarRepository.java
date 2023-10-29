package racingcar.repository;

import racingcar.entity.Car;

import java.util.HashMap;
import java.util.Map;

public class CarRepository {

    Map<String, Car> carMap = new HashMap<String,Car>();
    public Car save(String name) {
        Car createCar = new Car(name);
        carMap.put(name, createCar);
        return createCar;
    }

}
