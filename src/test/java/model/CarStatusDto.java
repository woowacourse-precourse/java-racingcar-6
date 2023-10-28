package model;

import java.util.*;
import java.util.stream.Collectors;

public class CarStatusDto {
    static Map<String,Car> cars = new HashMap();

    public void enrollCar(String carName) {
        if(findByNameObject(carName).equals(Optional.empty())) {
            cars.put(carName,new Car(carName,0));
        }
    }

    public Optional<Integer> findByNamePosition(String name) {
        return Optional.ofNullable(cars.get(name).position);
    }

    public Optional<Car> findByNameObject(String name) {
        return Optional.ofNullable(cars.get(name));
    }

    public Map<String, Integer> findAll() {
        return cars.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().position));
    }

    public void increaseCarPosition(String carName) {
        findByNameObject(carName).get().position++;
    }



}
